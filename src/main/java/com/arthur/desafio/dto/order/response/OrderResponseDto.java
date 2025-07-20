package com.arthur.desafio.dto.order.response;

import com.arthur.desafio.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderResponseDto{
    Long orderId;
    OrderStatus status;
    BigDecimal total;
    LocalDate orderDate;
}
