package com.arthur.desafio.repository.client;

import com.arthur.desafio.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {

    private final ClientSpring clientSpring;

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientSpring.findAll(pageable);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientSpring.findById(id);
    }

    @Override
    public Boolean hasClient() {
        return clientSpring.count() > 0;
    }

    @Override
    public Client save(Client client) {
        return clientSpring.save(client);
    }
}
