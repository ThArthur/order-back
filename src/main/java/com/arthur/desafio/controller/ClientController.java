package com.arthur.desafio.controller;

import com.arthur.desafio.dto.client.request.CreateClientDto;
import com.arthur.desafio.dto.client.response.ClientDto;
import com.arthur.desafio.service.client.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientDto>> getAllClients(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(clientService.getAllClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("create")
    public ResponseEntity<ClientDto> createClient(@RequestBody CreateClientDto client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

}
