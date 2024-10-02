package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User createUser(UserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .username(newUser.getName())
                .password(newUser.getPassword()) // TODO: Hashing des Passwort
                .build();


        return userRepository.save(user);


    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    public List<User> findAll () {
            return userRepository.findAll();
    }
    public User updateUser (Long id, User updatedUser){
        return userRepository.findById(id)
                    .map(user -> {
                        user.setUsername(updatedUser.getUsername());
                        user.setPassword(updatedUser.getPassword());
                        user.setEmail(updatedUser.getEmail());
                        return userRepository.save(user);
                    })
                    .orElseThrow(() -> new RuntimeException("User not found"));
        }

        public void deleteUser (Long id){

            try {
                userRepository.deleteById(id);
            } catch (Exception e) {
                throw new RuntimeException("ID not found");
            }
        }

}
