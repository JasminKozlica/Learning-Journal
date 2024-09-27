package com.example.demo;

import com.example.demo.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
<<<<<<< HEAD

import java.util.List;
import java.util.Optional;

=======
import java.util.List;
import java.util.Optional;
>>>>>>> cfb6c39493d052e7c475db5c639b1a3718b89788

@Service
public class UserService  {

    @Autowired
<<<<<<< HEAD
    private UserRepository userRepository;
=======
    private  UserRepository userRepository;
>>>>>>> cfb6c39493d052e7c475db5c639b1a3718b89788


    public User createUser(UserDto newUser) {
        User user = User.builder()
                .email(newUser.getEmail())
                .role(newUser.getRole())
                .username(newUser.getName())
                .password(newUser.getPassword()) // TODO: Hashing des Passwort
                .build();

<<<<<<< HEAD
//        Role studentRole = roleRepository.findByRoleName(RoleName.ROLE_STUDENT)
//                .orElseThrow(() ->  new RuntimeException("Role Student not found"));
//
//        Role adminRole = roleRepository.findByRoleName(RoleName.ROLE_ADMIN)
//                .orElseThrow(() ->  new RuntimeException("Role Admin not found"));

//        user.setRole(RoleName.ROLE_STUDENT);

=======
>>>>>>> cfb6c39493d052e7c475db5c639b1a3718b89788
        return userRepository.save(user);

//       Set<com.example.demo.Role> roles = new HashSet<>();
//        roles.add(studentRole);
//        user.setRole(roles);


    }

<<<<<<< HEAD
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
=======
    public Optional<User> findByUserName(String username){
        return userRepository.findByUsername(username);
>>>>>>> cfb6c39493d052e7c475db5c639b1a3718b89788
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setPassword(updatedUser.getPassword());
                    user.setEmail(updatedUser.getEmail());
                    user.setFeedback(updatedUser.getFeedback());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("ID not found");
        }
    }
}