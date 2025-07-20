package com.arthur.desafio.repository.orderProduct;

import com.arthur.desafio.model.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    OrderProduct save(OrderProduct orderProduct);

    List<OrderProduct> saveAll(List<OrderProduct> orderProducts);
}
