package com.hexagonal_architecture.product.domain.ports.inbound;

import java.util.UUID;

public interface DeleteProductPort {
    void deleteById(UUID id);
}
