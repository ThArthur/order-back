package com.arthur.desafio.service.product;

import com.arthur.desafio.dto.product.response.ProductDto;
import com.arthur.desafio.dto.product.request.CreateProductDto;
import com.arthur.desafio.model.Product;
import com.arthur.desafio.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductDto> getAllProducts(Pageable pageable) {

        return productRepository
                .findAll(pageable)
                .map(product -> ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
                );
    }

    @Override
    public ProductDto createProduct(CreateProductDto product) {
        Product productCreated = productRepository.save(
                Product.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
        );

        return ProductDto.builder()
                .id(productCreated.getId())
                .name(productCreated.getName())
                .price(productCreated.getPrice())
                .build();
    }
}
