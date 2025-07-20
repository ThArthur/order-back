package com.arthur.desafio.dto.product.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateProductPayloadDto {
    @NotBlank(message = "O nome do produto é obrigatório")
    private String name;

    @NotNull(message = "O preço é obrigatório")
    @DecimalMin(value = "0.01", inclusive = true, message = "O preço deve ser maior que zero")
    private BigDecimal price;
}
