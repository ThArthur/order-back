package com.arthur.desafio.repository.order;

import com.arthur.desafio.enums.OrderStatus;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OrderSpring extends JpaRepository<Order, Long> {
    List<Order> findByClientAndStatusAndOrderDateAfter(Client client, OrderStatus status, LocalDate orderDate);
    Page<Order> findAllByClientId(Pageable pageable, Long clientId);
}
