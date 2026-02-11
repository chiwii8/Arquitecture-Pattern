package com.example.user_service.controller;

import com.example.user_service.model.User;
import com.example.user_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * UserController.java
 * <p>
 * Description: Basic REST controller for user model
 *
 * @author aleja
 * @since 11/02/2026
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll(){
        return this.userService.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable long id){
        return this.userService.getUserId(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return this.userService.createUser(user);
    }

}
