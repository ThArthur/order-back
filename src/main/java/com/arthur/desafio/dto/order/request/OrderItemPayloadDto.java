package com.arthur.desafio.dto.order.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderItemPayloadDto {

    @NotNull(message = "O ID do produto é obrigatório")
    private Long productId;

    @Min(value = 1, message = "A quantidade deve ser no mínimo 1")
    private int quantity;
}

