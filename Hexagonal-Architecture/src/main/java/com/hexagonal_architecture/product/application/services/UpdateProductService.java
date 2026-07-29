package com.hexagonal_architecture.product.application.services;

import com.hexagonal_architecture.product.application.command.UpdateProductCommand;
import com.hexagonal_architecture.product.domain.exceptions.ProductNotFoundException;
import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.model.ProductId;
import com.hexagonal_architecture.product.domain.ports.inbound.UpdateProductPort;
import com.hexagonal_architecture.product.domain.ports.outbound.ProductH2Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * UpdateProductService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 29/07/2026
 */

@Service
public class UpdateProductService implements UpdateProductPort {

    private final ProductH2Repository repository;

    public UpdateProductService(ProductH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public Product update(UUID id, UpdateProductCommand command) {
        ProductId productId = ProductId.of(id);
        if(!repository.existsById(productId))
            throw new ProductNotFoundException(productId);

        Product product = Product.update(id, command.name(), command.description(), command.price());
        Product updatedProduct = repository.save(product);
        return updatedProduct;
    }
}
