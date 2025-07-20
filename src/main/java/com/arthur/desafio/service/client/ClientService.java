package com.arthur.desafio.service.client;

import com.arthur.desafio.dto.client.request.CreateClientPayloadDto;
import com.arthur.desafio.dto.client.response.ClientResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientService {

    Page<ClientResponseDto> getAllClients(Pageable pageable);
    ClientResponseDto createClient(CreateClientPayloadDto client);
    ClientResponseDto getClientById(Long id);
}
