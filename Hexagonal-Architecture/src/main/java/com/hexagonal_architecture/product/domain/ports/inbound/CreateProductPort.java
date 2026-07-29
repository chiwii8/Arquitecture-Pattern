package com.hexagonal_architecture.product.domain.ports.inbound;

import com.hexagonal_architecture.product.application.command.CreateProductCommand;
import com.hexagonal_architecture.product.domain.model.Product;

public interface CreateProductPort {
    Product create(CreateProductCommand command);
}
