package com.example.soa.services.user;

import com.example.soa.model.User;
import com.example.soa.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * UserService.java
 * <p>
 * Description: [Add the description of the class]
 *
 * @author aleja
 * @since 12/02/2026
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserbyId(long id){
        return this.userRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("User not found"));
    }

    public void createUser(User user){
        this.userRepository.save(user);
    }
}
