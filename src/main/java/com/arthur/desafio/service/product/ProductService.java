package com.arthur.desafio.service.product;

import com.arthur.desafio.dto.product.response.ProductRequestDto;
import com.arthur.desafio.dto.product.request.CreateProductPayloadDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    Page<ProductRequestDto> getAllProducts(Pageable pageable);

    ProductRequestDto createProduct(CreateProductPayloadDto product);
}
