package com.arthur.desafio.repository.order;

import com.arthur.desafio.model.OrderProduct;

import java.util.List;

public interface OrderProductRepository {
    OrderProduct save(OrderProduct orderProduct);

    List<OrderProduct> saveAll(List<OrderProduct> orderProducts);
}
