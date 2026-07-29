package com.hexagonal_architecture.product.infraestructure.inbound.dto.requests;

public record UpdateProductRequest(
        String name,
        String description,
        double price
) {
}
