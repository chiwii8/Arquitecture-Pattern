package com.hexagonal_architecture.product.infraestructure.inbound.dto;


import java.util.UUID;

public record ProductResponse (
        UUID id,
        String name,
        String description,
        double price
){ }
