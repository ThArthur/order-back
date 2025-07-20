package com.arthur.desafio.service.product;

import com.arthur.desafio.dto.product.response.ProductDto;
import com.arthur.desafio.dto.product.request.CreateProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<ProductDto> getAllProducts(Pageable pageable);

    ProductDto createProduct(CreateProductDto product);
}
