package com.arthur.desafio.controller;

import com.arthur.desafio.dto.product.response.ProductDto;
import com.arthur.desafio.dto.product.request.CreateProductDto;
import com.arthur.desafio.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getAllProducts(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(productService.getAllProducts(pageable));
    }

    @PostMapping("/create")
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto product) {
        return ResponseEntity.ok(productService.createProduct(product));
    }
}
