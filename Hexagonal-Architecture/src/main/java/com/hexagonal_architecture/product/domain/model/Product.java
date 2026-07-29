package com.hexagonal_architecture.product.domain.model;

import java.util.UUID;

/**
 * Product.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 15/06/2026
 */

public class Product {
    private ProductId id;
    private String name;
    private String description;
    private double price;

    public Product(ProductId id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /// Factory method that lets create and update the products attributes
    public static Product create(String name, String description, double price){
        return new Product(ProductId.newId(),name,description,price);
    }

    public static Product update(UUID id, String name, String description, double price){
        return new Product(ProductId.of(id),name,description,price);
    }

    public ProductId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
