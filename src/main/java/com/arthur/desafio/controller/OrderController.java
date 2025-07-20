package com.arthur.desafio.controller;

import com.arthur.desafio.dto.order.request.OrderRequestDto;
import com.arthur.desafio.dto.order.response.AllOrdersResponseDto;
import com.arthur.desafio.dto.order.response.OrderResponseDto;
import com.arthur.desafio.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<Page<AllOrdersResponseDto>> findAll(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(orderService.findAll(pageable));
    }

    @GetMapping("user/{clientId}/all-orders")
    public ResponseEntity<Page<OrderResponseDto>> getAllOrderByClientId(
            @PageableDefault(size = 10) Pageable pageable,
            @PathVariable Long clientId
    ) {
        return ResponseEntity.ok(orderService.findOrderByClientId(pageable, clientId));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
