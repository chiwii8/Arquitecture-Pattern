package com.example.task_service.exception;

/**
 * ExternalServiceException.java
 * <p>
 * Description: External exception, in this case the connection timeout of the microservice user-service
 *
 * @author aleja
 * @since 11/02/2026
 */

public class ExternalServiceException  extends RuntimeException{

    public  ExternalServiceException(String message){
        super(message);
    }
}
