package com.arthur.desafio.service.orderProduct;

import com.arthur.desafio.repository.order.OrderProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderProductService {

    @Autowired
    private OrderProductRepository orderProductRepository;
}
