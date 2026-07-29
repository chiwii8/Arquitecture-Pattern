package com.hexagonal_architecture.product.infraestructure.inbound;

import com.hexagonal_architecture.product.domain.exceptions.ProductNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ProductHandlerException.java
 * <p>
 * Description: This is an Exception handler for the operations for the Product
 *
 * @author aleja
 * @since 29/07/2026
 */

record ErrorMessage(String message){}

@RestControllerAdvice
public class ProductHandlerException {

    private static final Logger log = LoggerFactory.getLogger(ProductHandlerException.class);

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorMessage> handlerNotFoundProduct(Exception ex){
        log.warn(ex.getMessage(),ex.getCause());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorMessage(ex.getMessage()));
    }
}
