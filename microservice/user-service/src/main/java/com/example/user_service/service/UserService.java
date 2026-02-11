package com.example.user_service.service;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 11/02/2026
 */

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return this.userRepository.findAll();
    }

    public User getUserId(long id){
        return this.userRepository.findById(id).orElseGet(User::new);
    }

    public User createUser(User user){
        return this.userRepository.save(user);
    }
}
