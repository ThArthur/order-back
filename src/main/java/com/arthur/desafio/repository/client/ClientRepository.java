package com.arthur.desafio.repository.client;


import com.arthur.desafio.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface ClientRepository {

    Boolean hasClient();

    Client save(Client client);

    Page<Client> findAll(Pageable pageable);

    Optional<Client> findById(Long id);
}
