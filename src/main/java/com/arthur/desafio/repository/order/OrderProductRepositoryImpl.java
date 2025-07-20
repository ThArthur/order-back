package com.arthur.desafio.repository.order;

import com.arthur.desafio.model.OrderProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderProductRepositoryImpl implements OrderProductRepository {

    private final OrderProductSpring orderProductSpring;

    @Override
    public OrderProduct save(OrderProduct orderProduct) {
        return orderProductSpring.save(orderProduct);
    }

    @Override
    public List<OrderProduct> saveAll(List<OrderProduct> orderProducts) {
        return orderProductSpring.saveAll(orderProducts);
    }
}
