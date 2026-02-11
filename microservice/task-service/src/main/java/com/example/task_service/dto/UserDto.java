package com.example.task_service.dto;

/**
 * UserDto.java
 * <p>
 * Description: record DTO to consume the REST API
 *
 * @author aleja
 * @since 11/02/2026
 */

public record UserDto(long id,
     String name,
     String email){}
