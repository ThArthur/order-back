package com.arthur.desafio.repository.product;

import com.arthur.desafio.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {

    private final ProductSpring productSpring;

    @Override
    public Boolean hasProduct() {
        return productSpring.count() > 0;
    }

    @Override
    public Product save(Product product) {
        productSpring.save(product);
        return product;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productSpring.findAll(pageable);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productSpring.findById(id);
    }

    @Override
    public List<Product> findAllByIds(List<Long> ids) {
        return productSpring.findAllById(ids);
    }
}
