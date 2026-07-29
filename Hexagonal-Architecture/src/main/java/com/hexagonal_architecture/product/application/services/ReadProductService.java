package com.hexagonal_architecture.product.application.services;

import com.hexagonal_architecture.product.domain.exceptions.ProductNotFoundException;
import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.model.ProductId;
import com.hexagonal_architecture.product.domain.ports.inbound.ReadProductPort;
import com.hexagonal_architecture.product.domain.ports.outbound.ProductH2Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * ReadProductService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 29/07/2026
 */

@Service
public class ReadProductService implements ReadProductPort {

    private final ProductH2Repository repository;

    public ReadProductService(ProductH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public Product findById(UUID id) {
        ProductId productId = ProductId.of(id);
        return findOrThrow(productId);
    }

    @Override
    public List<Product> findAll() {
        return repository.listAll();
    }

    private Product findOrThrow(ProductId id){
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
