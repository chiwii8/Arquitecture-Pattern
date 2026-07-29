package com.hexagonal_architecture.product.domain.ports.inbound;

import com.hexagonal_architecture.product.application.command.UpdateProductCommand;
import com.hexagonal_architecture.product.domain.model.Product;

import java.util.UUID;

public interface UpdateProductPort {
    Product update(UUID id, UpdateProductCommand command);
}
