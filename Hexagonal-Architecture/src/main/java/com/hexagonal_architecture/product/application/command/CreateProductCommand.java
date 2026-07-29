package com.hexagonal_architecture.product.application.command;

public record CreateProductCommand(
        String name,
        String description,
        double price
) {
}
