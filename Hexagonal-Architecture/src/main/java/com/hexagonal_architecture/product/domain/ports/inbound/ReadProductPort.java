package com.hexagonal_architecture.product.domain.ports.inbound;

import com.hexagonal_architecture.product.domain.model.Product;

import java.util.List;
import java.util.UUID;

public interface ReadProductPort {
    Product findById(UUID id);
    List<Product> findAll();
}
