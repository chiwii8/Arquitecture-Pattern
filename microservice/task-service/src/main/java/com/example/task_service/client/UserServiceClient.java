package com.example.task_service.client;

import com.example.task_service.dto.UserDto;
import com.example.task_service.exception.ExternalServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * UserServiceClient.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 11/02/2026
 */

@Component
public class UserServiceClient {
    private final RestTemplate restTemplate;
    private final String defaultUri= "http://localhost:8081/users";

    public UserServiceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<UserDto> getUsers(){

        try{
            ResponseEntity<UserDto[]> responseEntity = restTemplate.getForEntity(defaultUri,UserDto[].class);

            return  List.of(responseEntity.getBody());

        }catch (ResourceAccessException e){
            throw new ExternalServiceException("User service is unreachable or time out");
        }catch (Exception e){
            throw new ExternalServiceException("User service uncatched server or client error:" );
        }

    }
}
