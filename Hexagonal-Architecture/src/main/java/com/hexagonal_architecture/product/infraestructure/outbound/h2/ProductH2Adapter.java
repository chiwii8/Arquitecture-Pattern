package com.hexagonal_architecture.product.infraestructure.outbound.h2;

import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.model.ProductId;
import com.hexagonal_architecture.product.domain.ports.outbound.ProductH2Repository;
import com.hexagonal_architecture.product.infraestructure.outbound.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ProductH2Adapter.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 29/07/2026
 */

@Component
public class ProductH2Adapter implements ProductH2Repository {


    private final SpringProductRepository repository;

    public ProductH2Adapter(SpringProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = ProductMapper.toEntity(product);
        ProductEntity saved = repository.save(entity);
        return ProductMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(ProductId id) {
        return repository.findById(id.value())
                .map(ProductMapper::toDomain);
    }

    @Override
    public List<Product> listAll() {
        return repository.findAll()
                .stream().map(ProductMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(ProductId id) {
        repository.deleteById(id.value());
    }

    @Override
    public boolean existsById(ProductId id) {
        return repository.existsById(id.value());
    }
}
