package com.arthur.desafio.repository.orderProduct;

import com.arthur.desafio.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductSpring extends JpaRepository<OrderProduct, Long> {
}
