package com.example.task_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * GlobalExceptionHandler.java
 * <p>
 * Description: Exception handler
 *
 * @author aleja
 * @since 11/02/2026
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<Map<String,String>> handleExternalService( ExternalServiceException ex){
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());

        return  ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(error);
    }
}
