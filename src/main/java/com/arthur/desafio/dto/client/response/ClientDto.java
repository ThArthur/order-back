package com.arthur.desafio.dto.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientDto {

    private Long id;
    private String name;
    private BigDecimal creditLimit;
    private BigDecimal spendThisMonth;
}
