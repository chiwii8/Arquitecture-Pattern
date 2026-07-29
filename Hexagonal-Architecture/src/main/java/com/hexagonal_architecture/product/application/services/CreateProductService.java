package com.hexagonal_architecture.product.application.services;

import com.hexagonal_architecture.product.application.command.CreateProductCommand;
import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.ports.inbound.CreateProductPort;
import com.hexagonal_architecture.product.domain.ports.outbound.ProductH2Repository;
import org.springframework.stereotype.Service;

/**
 * CreateProductService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 29/07/2026
 */

@Service
public class CreateProductService implements CreateProductPort {

    private final ProductH2Repository repositoryPort;

    public CreateProductService(ProductH2Repository repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Product create(CreateProductCommand command) {

        Product product = Product.create(command.name(), command.description(), command.price());
        return repositoryPort.save(product);
    }
}
