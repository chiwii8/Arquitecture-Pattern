package com.hexagonal_architecture.product.application.command;


public record UpdateProductCommand(
        String name,
        String description,
        double price
) {
}
