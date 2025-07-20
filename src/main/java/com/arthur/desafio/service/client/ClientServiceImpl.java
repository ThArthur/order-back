package com.arthur.desafio.service.client;

import com.arthur.desafio.dto.client.request.CreateClientDto;
import com.arthur.desafio.dto.client.response.ClientDto;
import com.arthur.desafio.model.Client;
import com.arthur.desafio.repository.client.ClientRepository;
import com.arthur.desafio.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    private final OrderService orderService;

    @Override
    public Page<ClientDto> getAllClients(Pageable pageable) {

        return clientRepository.findAll(pageable)
                .map(client -> ClientDto.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .creditLimit(client.getCreditLimit())
                        .spendThisMonth(orderService.getTotalSpendThisMonthByClient(client.getId()))
                        .build());
    }

    @Override
    public ClientDto createClient(CreateClientDto client) {
        Client savedClient = clientRepository.save(
                Client.builder()
                        .name(client.getName())
                        .creditLimit(client.getCreditLimit())
                        .build()
        );

        return ClientDto.builder()
                .id(savedClient.getId())
                .name(savedClient.getName())
                .creditLimit(savedClient.getCreditLimit())
                .build();
    }

    @Override
    public ClientDto getClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName())
                .creditLimit(client.getCreditLimit())
                .build();
    }
}
