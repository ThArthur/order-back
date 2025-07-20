package com.arthur.desafio.service.order;

import com.arthur.desafio.dto.order.request.OrderRequestDto;
import com.arthur.desafio.dto.order.response.AllOrdersResponseDto;
import com.arthur.desafio.dto.order.response.OrderResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface OrderService {
   OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

   Page<AllOrdersResponseDto> findAll(Pageable pageable);

   Page<OrderResponseDto> findOrderByClientId(Pageable pageable, Long clientId);

   BigDecimal getTotalSpendThisMonthByClient(Long clientId);

}
