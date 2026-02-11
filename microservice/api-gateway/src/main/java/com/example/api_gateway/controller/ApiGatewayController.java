package com.example.api_gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * ApiGatewayController.java
 * <p>
 * Description: centralizes all the client request to a single entry point, the client communicate with the gateway, not each microservice
 * For this example, we only use the GET method from tasks and users. Only implemented all the endpoints for user-service
 *
 * @author aleja
 * @since 11/02/2026
 */

@RestController
@RequestMapping("/api")
public class ApiGatewayController {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiGatewayController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/tasks")
    public ResponseEntity<Object> getTasks() {
        String url = "http://localhost:8080/tasks";
        return restTemplate.getForEntity(url, Object.class);
    }

    @GetMapping("/users")
    public ResponseEntity<Object> getUsers() {
        String url = "http://localhost:8081/users";
        return restTemplate.getForEntity(url, Object.class);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody Object user){
        return restTemplate.postForEntity("http://localhost:8081/users", user, Object.class);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable long id){
        String url = "http://localhost:8081/users/" + id;
        return restTemplate.getForEntity(url, Object.class);
    }


}
