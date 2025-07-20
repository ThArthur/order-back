package com.arthur.desafio.repository.product;

import com.arthur.desafio.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpring extends JpaRepository<Product, Long> {
}
