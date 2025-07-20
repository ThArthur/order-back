package com.arthur.desafio.dto.order.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequestDto {

    Long clientId;
    List<OrderItemDto> items;
}
