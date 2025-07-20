package com.arthur.desafio.enums;

import java.util.Random;

public enum OrderStatus {
    APROVADO,
    REJEITADO;

    public static OrderStatus getRandomEnum() {
        int random = new Random().nextInt();

        return random % 2 == 0 ? APROVADO : REJEITADO;
    }
}
