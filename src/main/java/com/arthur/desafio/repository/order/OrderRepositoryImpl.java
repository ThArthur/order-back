package com.arthur.desafio.repository.order;


import com.arthur.desafio.enums.OrderStatus;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderSpring orderSpring;


    @Override
    public Boolean hasOrder() {
        return orderSpring.count() > 0;
    }

    @Override
    public Order save(Order order) {
        return orderSpring.save(order);
    }

    @Override
    public List<Order> findByClientAndOrderDateAfterAndStatus(Client client, LocalDate orderDate, OrderStatus status) {
        return orderSpring.findByClientAndStatusAndOrderDateAfter(client, status, orderDate);
    }

    @Override
    public Page<Order> findAllByClientId(Pageable pageable, Long clientId) {
        return orderSpring.findAllByClientId(pageable, clientId);
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return orderSpring.findAll(pageable);
    }
}
