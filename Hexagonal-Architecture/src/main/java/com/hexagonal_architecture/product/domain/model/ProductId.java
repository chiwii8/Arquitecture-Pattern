package com.hexagonal_architecture.product.domain.model;

import java.util.Objects;
import java.util.UUID;

public record ProductId(UUID value) {

    public ProductId(UUID value){
        this.value = Objects.requireNonNull(value,"The Identifier cannot be null");
    }


    /**
     * Generate a new identity, for the product
     * @return the new identity generated
     */
    public static ProductId newId(){
        return new ProductId(UUID.randomUUID());
    }


    /**
     * rebuild an existing identity from a Product from the DB
     * @param value identity rebuild
     */
    public static ProductId of(UUID value){
        return new ProductId(value);
    }
}
