package com.arthur.desafio.repository.orderProduct;

import com.arthur.desafio.enums.OrderStatus;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository {

    Boolean hasOrder();

    Order save(Order order);

    List<Order> findByClientAndOrderDateAfterAndStatus(Client client, LocalDate orderDate, OrderStatus status);

    Page<Order> findAllByClientId(Pageable pageable, Long clientId);

    Page<Order> findAll(Pageable pageable);
}
