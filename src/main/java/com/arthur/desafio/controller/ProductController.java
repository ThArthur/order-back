package com.arthur.desafio.controller;

import com.arthur.desafio.dto.product.response.ProductRequestDto;
import com.arthur.desafio.dto.product.request.CreateProductPayloadDto;
import com.arthur.desafio.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductRequestDto>> getAllProducts(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductRequestDto> createProduct(@RequestBody @Valid CreateProductPayloadDto product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
}
