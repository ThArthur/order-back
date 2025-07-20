package com.arthur.desafio.config;

import com.arthur.desafio.dto.order.request.OrderItemPayloadDto;
import com.arthur.desafio.dto.order.request.OrderPayloadDto;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Product;
import com.arthur.desafio.repository.client.ClientRepository;
import com.arthur.desafio.repository.order.OrderRepository;
import com.arthur.desafio.repository.product.ProductRepository;
import com.arthur.desafio.service.order.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    public DataInitializer(ClientRepository clientRepository,
                           ProductRepository productRepository,
                           OrderRepository orderRepository,
                           OrderService orderService) {
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(!clientRepository.hasClient()) {
            for (int i = 1; i <= 20; i++) {
                clientRepository.save(Client.builder()
                        .name("Cliente " + i)
                        .creditLimit(BigDecimal.valueOf(1000 + i * 100))
                        .build());
            }
            System.out.println("Clientes inicializados.");
        }

        if(!productRepository.hasProduct()) {
            for (int i = 1; i <= 20; i++) {
                productRepository.save(Product.builder()
                        .name("Produto " + i)
                        .price(BigDecimal.valueOf(10 + i * 5))
                        .build());
            }
            System.out.println("Produtos inicializados.");
        }


        if (!orderRepository.hasOrder()) {

            OrderItemPayloadDto item1 = OrderItemPayloadDto.builder()
                    .productId(1L)
                    .quantity(2)
                    .build();

            OrderItemPayloadDto item2 = OrderItemPayloadDto.builder()
                    .productId(2L)
                    .quantity(3)
                    .build();

            OrderPayloadDto order1 = OrderPayloadDto.builder()
                    .clientId(3L)
                    .items(List.of(item1, item2))
                    .build();

            orderService.createOrder(order1);

            OrderItemPayloadDto item3 = OrderItemPayloadDto.builder()
                    .productId(1L)
                    .quantity(1)
                    .build();

            OrderItemPayloadDto item4 = OrderItemPayloadDto.builder()
                    .productId(2L)
                    .quantity(5)
                    .build();

            OrderItemPayloadDto item5 = OrderItemPayloadDto.builder()
                    .productId(3L)
                    .quantity(4)
                    .build();

            OrderPayloadDto order2 = OrderPayloadDto.builder()
                    .clientId(2L)
                    .items(List.of(item3, item4, item5))
                    .build();

            orderService.createOrder(order2);

            System.out.println("Pedidos inicializados.");
        }
    }
}
