package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    @Autowired
    private  UserRepository userRepository;

    public User createUser(UserDto newUser){
        User user = User.builder()
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .username(newUser.getName())
                .password(newUser.getPassword()) // TODO: Hashing des Passwort
                .build();

        return userRepository.save(user);

//       Set<com.example.demo.Role> roles = new HashSet<>();
//        roles.add(studentRole);
//        user.setRole(roles);


    }

    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser){
        return userRepository.findById(id)
                .map(user->{
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setEmail(updatedUser.getEmail());
                    user.setFeedback(updatedUser.getFeedback());
                    return userRepository.save(user);
                })
                .orElseThrow(()->  new RuntimeException("User not found"));
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
