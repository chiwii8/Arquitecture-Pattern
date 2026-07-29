package com.hexagonal_architecture.product.infraestructure.outbound.h2;

import com.hexagonal_architecture.product.domain.model.ProductId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

/**
 * ProductEntity.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 16/06/2026
 */

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private String description;
    private double price;

    public ProductEntity(){}

    public ProductEntity(UUID id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductEntity(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UUID getId() {
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
