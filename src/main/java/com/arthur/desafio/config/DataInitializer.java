package com.arthur.desafio.config;

import com.arthur.desafio.enums.OrderStatus;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Order;
import com.arthur.desafio.model.Product;
import com.arthur.desafio.repository.client.ClientRepository;
import com.arthur.desafio.repository.orderProduct.OrderRepository;
import com.arthur.desafio.repository.product.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final ClientRepository clientRepository;
//    private final ProductRepository productRepository;
//    private final OrderRepository orderRepository;
//
//    public DataInitializer(ClientRepository clientRepository, ProductRepository productRepository, OrderRepository orderRepository) {
//        this.clientRepository = clientRepository;
//        this.productRepository = productRepository;
//        this.orderRepository = orderRepository;
//    }
//
//    @Override
//    public void run(String... args) {
//        if (!clientRepository.hasClient()) {
//            for (int i = 1; i <= 10; i++) {
//                Client client = Client.builder()
//                        .name("Client " + i)
//                        .creditLimit(BigDecimal.valueOf(1000 + i * 100))
//                        .build();
//                clientRepository.save(client);
//            }
//            System.out.println("Clientes inicializados.");
//        }
//
//        if (!productRepository.hasProduct()) {
//            for (int i = 1; i <= 10; i++) {
//                Product product = Product.builder()
//                        .name("Product " + i)
//                        .price(BigDecimal.valueOf(10 + i * 2))
//                        .build();
//                productRepository.save(product);
//            }
//            System.out.println("Produtos inicializados.");
//        }
//
//        if (!orderRepository.hasOrder()) {
//            Client client = clientRepository.findById(1L).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//
//            for (int i = 1; i <= 10; i++) {
//                Order order = Order.builder()
//                        .orderDate(LocalDate.now())
//                        .status(OrderStatus.getRandomEnum())
//                        .totalValue(BigDecimal.valueOf(10 + i * 2))
//                        .client(client)
//                        .build();
//                orderRepository.save(order);
//            }
//
//            System.out.println("Pedidos inicializados.");
//        }
//    }
//}
