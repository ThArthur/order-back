package com.arthur.desafio.repository.product;

import com.arthur.desafio.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Boolean hasProduct();

    Product save(Product product);

    Page<Product> findAll(Pageable pageable);

    Optional<Product> findById(Long id);

    List<Product> findAllByIds(List<Long> ids);
}
