package com.arthur.desafio.service.order;

import com.arthur.desafio.dto.order.request.OrderItemPayloadDto;
import com.arthur.desafio.dto.order.request.OrderPayloadDto;
import com.arthur.desafio.dto.order.response.AllOrdersResponseDto;
import com.arthur.desafio.dto.order.response.OrderResponseDto;
import com.arthur.desafio.enums.OrderStatus;
import com.arthur.desafio.exception.NotFoundException;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.model.Order;
import com.arthur.desafio.model.OrderProduct;
import com.arthur.desafio.model.Product;
import com.arthur.desafio.repository.client.ClientRepository;
import com.arthur.desafio.repository.orderProduct.OrderProductRepository;
import com.arthur.desafio.repository.order.OrderRepository;
import com.arthur.desafio.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final ProductRepository productRepository;
    private final OrderProductRepository orderProductRepository;

    public BigDecimal getTotalSpendThisMonthByClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado")
        );

        List<Order> orders = orderRepository.findByClientAndOrderDateAfterAndStatus(
                client,
                LocalDate.now().minusDays(30),
                OrderStatus.APROVADO
        );

        BigDecimal totalSpendThisMonth = BigDecimal.ZERO;
        for (Order order : orders) {
            totalSpendThisMonth = totalSpendThisMonth.add(order.getTotalValue());
        }

        return totalSpendThisMonth;
    }

    public OrderResponseDto createOrder(OrderPayloadDto orderPayloadDto) {

        Client client = clientRepository.findById(orderPayloadDto.getClientId())
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado"));

        List<Long> productIds = orderPayloadDto.getItems().stream()
                .map(OrderItemPayloadDto::getProductId)
                .toList();

        Map<Long, Product> productMap = productRepository.findAllByIds(productIds)
                .stream()
                .collect(Collectors.toMap(Product::getId, p -> p));

        if (productMap.size() != productIds.size()) {

            Set<Long> foundIds = productMap.keySet();
            List<Long> missingIds = productIds.stream()
                    .filter(id -> !foundIds.contains(id))
                    .toList();

            throw new NotFoundException("Produtos não encontrados para os IDs: " + missingIds);
        }

        List<Order> previousOrders = orderRepository.findByClientAndOrderDateAfterAndStatus(
                client,
                LocalDate.now().minusDays(30),
                OrderStatus.APROVADO
        );

        BigDecimal previousTotalValue = previousOrders.stream()
                .map(Order::getTotalValue)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        List<OrderProduct> orderProducts = new ArrayList<>();

        BigDecimal orderTotalValue = BigDecimal.ZERO;

        for (OrderItemPayloadDto item : orderPayloadDto.getItems()) {
            Product product = productMap.get(item.getProductId());

            if (product == null) {
                throw new NotFoundException("Produto com ID " + item.getProductId() + " não encontrado.");
            }

            BigDecimal subtotal = product.getPrice().multiply(new BigDecimal(item.getQuantity()));
            orderTotalValue = subtotal.add(orderTotalValue);

            orderProducts.add(
                    OrderProduct.builder()
                            .product(product)
                            .quantity(item.getQuantity())
                            .subtotal(subtotal)
                            .build()
            );
        }

        OrderStatus currentOrderStatus = orderTotalValue.add(previousTotalValue).compareTo(client.getCreditLimit()) <= 0
                ? OrderStatus.APROVADO
                : OrderStatus.REJEITADO;

        Order order = Order.builder()
                .client(client)
                .orderDate(LocalDate.now())
                .totalValue(orderTotalValue)
                .status(currentOrderStatus)
                .build();

        Order savedOrder = orderRepository.save(order);

        for (OrderProduct orderProduct : orderProducts) {
            orderProduct.setOrder(order);
        }

        orderProductRepository.saveAll(orderProducts);

        return OrderResponseDto.builder()
                .orderId(savedOrder.getId())
                .status(savedOrder.getStatus())
                .total(savedOrder.getTotalValue())
                .orderDate(savedOrder.getOrderDate())
                .build();
    }

    @Override
    public Page<AllOrdersResponseDto> findAll(Pageable pageable) {
        Page<Order> orders = orderRepository.findAll(pageable);

        return orders
                .map(order -> AllOrdersResponseDto.builder()
                        .orderId(order.getId())
                        .status(order.getStatus())
                        .total(order.getTotalValue())
                        .orderDate(order.getOrderDate())
                        .client(order.getClient().getName())
                        .build()
                );
    }

    @Override
    public Page<OrderResponseDto> findOrderByClientId(Pageable pageable, Long clientId) {
        Page<Order> orders = orderRepository.findAllByClientId(pageable, clientId);

        return orders
                .map(order -> OrderResponseDto.builder()
                        .orderId(order.getId())
                        .status(order.getStatus())
                        .total(order.getTotalValue())
                        .orderDate(order.getOrderDate())
                        .build()
                );
    }

}
