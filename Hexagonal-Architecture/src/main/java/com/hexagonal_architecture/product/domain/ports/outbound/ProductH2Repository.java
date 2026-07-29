package com.hexagonal_architecture.product.domain.ports.outbound;

import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.model.ProductId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductH2Repository {
    Product save(Product product);
    Optional<Product> findById(ProductId id);
    List<Product> listAll();
    void deleteById(ProductId id);
    boolean existsById(ProductId id);

}
