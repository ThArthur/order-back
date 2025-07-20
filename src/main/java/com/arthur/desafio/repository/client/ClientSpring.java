package com.arthur.desafio.repository.client;

import com.arthur.desafio.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientSpring extends JpaRepository<Client, Long> {
}
