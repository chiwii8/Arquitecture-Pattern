package com.hexagonal_architecture.product.infraestructure.inbound;

import com.hexagonal_architecture.product.application.command.CreateProductCommand;
import com.hexagonal_architecture.product.application.command.UpdateProductCommand;
import com.hexagonal_architecture.product.domain.model.Product;
import com.hexagonal_architecture.product.domain.ports.inbound.CreateProductPort;
import com.hexagonal_architecture.product.domain.ports.inbound.DeleteProductPort;
import com.hexagonal_architecture.product.domain.ports.inbound.ReadProductPort;
import com.hexagonal_architecture.product.domain.ports.inbound.UpdateProductPort;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.ProductDtoMapper;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.ProductResponse;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.requests.CreateProductRequest;
import com.hexagonal_architecture.product.infraestructure.inbound.dto.requests.UpdateProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * ProductController.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 16/06/2026
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final CreateProductPort createProductPort;
    private final ReadProductPort readProductPort;
    private final UpdateProductPort updateProductPort;
    private final DeleteProductPort deleteProductPort;

    public ProductController(CreateProductPort createProductPort, ReadProductPort readProductPort, UpdateProductPort updateProductPort, DeleteProductPort deleteProductPort) {
        this.createProductPort = createProductPort;
        this.readProductPort = readProductPort;
        this.updateProductPort = updateProductPort;
        this.deleteProductPort = deleteProductPort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> create(@RequestBody CreateProductRequest request){
        CreateProductCommand command = ProductDtoMapper.toCreateCommand(request);

        Product product = createProductPort.create(command);
        ProductResponse response = ProductDtoMapper.toResponse(product);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable UUID id){
        Product product = readProductPort.findById(id);

        ProductResponse response = ProductDtoMapper.toResponse(product);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> listAll(){
        List<Product> products = readProductPort.findAll();

        List<ProductResponse> responses = products.stream()
                .map(ProductDtoMapper::toResponse)
                .toList();

        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateById(@PathVariable UUID id, @RequestBody UpdateProductRequest request){
        UpdateProductCommand command = ProductDtoMapper.toUpdateCommand(request);
        Product product = updateProductPort.update(id,command);

        ProductResponse response = ProductDtoMapper.toResponse(product);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id){
        deleteProductPort.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
