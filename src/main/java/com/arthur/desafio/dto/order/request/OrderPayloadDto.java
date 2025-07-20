package com.arthur.desafio.dto.order.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPayloadDto {

    @NotNull(message = "O ID do cliente é obrigatório")
    private Long clientId;

    @NotEmpty(message = "A lista de itens do pedido não pode estar vazia")
    private List<@Valid OrderItemPayloadDto> items;
}
