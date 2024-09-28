package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

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

//        Role studentRole = roleRepository.findByRoleName(RoleName.ROLE_STUDENT)
//                .orElseThrow(() ->  new RuntimeException("Role Student not found"));
//
//        Role adminRole = roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
//                .orElseThrow(() ->  new RuntimeException("Role Admin not found"));

//        user.setRole(RoleName.ROLE_STUDENT);

        return userRepository.save(user);

//       Set<com.example.demo.Role> roles = new HashSet<>();
//        roles.add(studentRole);
//        user.setRole(roles);


    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findUserById(id);
    }
        public List<User> getAllUsers () {
            return userRepository.findAll();
        }

        public User updateUser (Long id, User updatedUser){
            return userRepository.findById(id)
                    .map(user -> {
                        user.setUsername(updatedUser.getUsername());
                        user.setPassword(updatedUser.getPassword());
                        user.setEmail(updatedUser.getEmail());
//                        user.setFeedback(updatedUser.getFeedback());
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
