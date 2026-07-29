package com.hexagonal_architecture.product.infraestructure.inbound.dto.requests;

public record CreateProductRequest(
        String name,
        String description,
        double price
) {
}
