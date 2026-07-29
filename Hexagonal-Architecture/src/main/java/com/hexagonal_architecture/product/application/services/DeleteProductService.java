package com.hexagonal_architecture.product.application.services;

import com.hexagonal_architecture.product.domain.model.ProductId;
import com.hexagonal_architecture.product.domain.ports.inbound.DeleteProductPort;
import com.hexagonal_architecture.product.domain.ports.outbound.ProductH2Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * DeleteProductService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 29/07/2026
 */

@Service
public class DeleteProductService implements DeleteProductPort {

    private final ProductH2Repository repository;

    public DeleteProductService(ProductH2Repository repository) {
        this.repository = repository;
    }

    @Override
    public void deleteById(UUID id) {
        ProductId productId = ProductId.of(id);
        if(repository.existsById(productId))
            repository.deleteById(productId);
    }
}
