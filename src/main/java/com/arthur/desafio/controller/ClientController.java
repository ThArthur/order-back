package com.arthur.desafio.controller;

import com.arthur.desafio.dto.client.request.CreateClientPayloadDto;
import com.arthur.desafio.dto.client.response.ClientResponseDto;
import com.arthur.desafio.service.client.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<Page<ClientResponseDto>> getAllClients(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(clientService.getAllClients(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @PostMapping("create")
    public ResponseEntity<ClientResponseDto> createClient(@RequestBody @Valid CreateClientPayloadDto client) {
        return ResponseEntity.ok(clientService.createClient(client));
    }

}
