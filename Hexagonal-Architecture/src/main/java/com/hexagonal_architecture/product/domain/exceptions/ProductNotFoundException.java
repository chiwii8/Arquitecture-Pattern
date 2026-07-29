package com.hexagonal_architecture.product.domain.exceptions;

import com.hexagonal_architecture.product.domain.model.ProductId;

import java.util.UUID;

/**
 * ProductNotFoundException.java
 * <p>
 * Description: Implementation of controlled exception to the not found in the DB the product by the identifier searched
 *
 * @author aleja
 * @since 29/07/2026
 */

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(ProductId productId){
        super("The product" + productId.value() + " cannot be found");
    }
}
