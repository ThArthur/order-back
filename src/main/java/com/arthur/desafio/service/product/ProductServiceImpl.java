package com.arthur.desafio.service.product;

import com.arthur.desafio.dto.product.response.ProductRequestDto;
import com.arthur.desafio.dto.product.request.CreateProductPayloadDto;
import com.arthur.desafio.model.Product;
import com.arthur.desafio.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Page<ProductRequestDto> getAllProducts(Pageable pageable) {

        return productRepository
                .findAll(pageable)
                .map(product -> ProductRequestDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
                );
    }

    @Override
    public ProductRequestDto createProduct(CreateProductPayloadDto product) {
        Product productCreated = productRepository.save(
                Product.builder()
                        .name(product.getName())
                        .price(product.getPrice())
                        .build()
        );

        return ProductRequestDto.builder()
                .id(productCreated.getId())
                .name(productCreated.getName())
                .price(productCreated.getPrice())
                .build();
    }
}
