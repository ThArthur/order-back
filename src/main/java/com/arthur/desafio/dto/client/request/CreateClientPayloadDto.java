package com.arthur.desafio.dto.client.request;

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
public class CreateClientPayloadDto {

    @NotNull(message = "Nome é obrigatório")
    @NotBlank(message = "O Nome não pode estar em branco")
    private String name;

    @NotNull(message = "O Limite de crédito é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O Limite deve ser maior que zero")
    private BigDecimal creditLimit;
}
