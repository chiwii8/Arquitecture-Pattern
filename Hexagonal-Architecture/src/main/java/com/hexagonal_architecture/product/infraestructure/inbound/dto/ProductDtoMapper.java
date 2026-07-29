package com.hexagonal_architecture.product.infraestructure.inbound.dto;

import com.hexagonal_architecture.product.application.command.CreateProductCommand;
import com.hexagonal_architecture.product.application.command.UpdateProductCommand;
import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.requests.CreateProductRequest;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.requests.UpdateProductRequest;

/**
 * ProductDtoMapper.java
 * <p>
 * Description: This is a mapper that encapsulate transform
 *
 * @author aleja
 * @since 29/07/2026
 */

public class ProductDtoMapper {
    private ProductDtoMapper(){}

    public static ProductResponse toResponse(Product product){
        if(product == null) return null;

        return new ProductResponse(
                product.getId().value(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public static CreateProductCommand toCreateCommand(CreateProductRequest request){
        if(request == null) return null;

        return new CreateProductCommand(
                request.name(),
                request.description(),
                request.price()
        );
    }

    public static UpdateProductCommand toUpdateCommand(UpdateProductRequest request){
        if(request == null) return null;

        return new UpdateProductCommand(
                request.name(),
                request.description(),
                request.price()
        );
    }
}
