package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
        private PasswordEncoder passwordEncoder;  // Injecting password encoder for hashing

    // Create a new user
    public User createUser(UserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .username(newUser.getName())
                .password(passwordEncoder.encode(newUser.getPassword())) // Hashing the password
                .build();
        return userRepository.save(user);
    }

    // Find a user by ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user information
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(passwordEncoder.encode(updatedUser.getPassword())); // Hashing on update
                    user.setEmail(updatedUser.getEmail());
                    // user.setFeedback(updatedUser.getFeedback()); // Uncomment if feedback is needed
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Delete a user by ID
    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found", e);
        }
    }
}