package com.hexagonal_architecture.product.infraestructure.outbound;

import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.model.ProductId;
import com.hexagonal_architecture.product.infraestructure.outbound.h2.ProductEntity;

/**
 * ProductMapper.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 16/06/2026
 */

public class ProductMapper {
    private ProductMapper(){}

    public static Product toDomain(ProductEntity entity){
        if(entity == null) return null;
        return new Product(
                ProductId.of(entity.getId()),
                entity.getName(),
                entity.getDescription(),
                entity.getPrice()
        );
    }

    public static ProductEntity toEntity(Product product){
        if(product == null) return null;

        return new ProductEntity(
                product.getId().value(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }
}
