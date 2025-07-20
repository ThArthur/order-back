package com.arthur.desafio.service.client;

import com.arthur.desafio.dto.client.request.CreateClientDto;
import com.arthur.desafio.dto.client.response.ClientDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {

    Page<ClientDto> getAllClients(Pageable pageable);
    ClientDto createClient(CreateClientDto client);
    ClientDto getClientById(Long id);
}
