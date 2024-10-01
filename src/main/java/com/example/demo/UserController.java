package com.example.demo;


import com.example.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;


=======
>>>>>>> b4d8b1a360012783ee10b0643241cbb880fe64bf
@AllArgsConstructor
@RestController
@Controller
@RequestMapping("/users")
public class UserController {
    private  UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser =  userService.createUser(new UserDto(user.getUsername(), user.getEmail(), user.getRole(),user.getPassword()));
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){

        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


<<<<<<< HEAD
    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){

        Optional<User> user = userService.findUserById(id);
                return ResponseEntity.ok(user.orElseThrow(()
                        -> new RuntimeException("User whit ID not found")));
    }
=======
//    @GetMapping("/id")
//    public ResponseEntity<User> findUserById(@PathVariable Long id){
//        User user = userService.findUserById(Long id);
//                return ResponseEntity.ok(user);
//    }
>>>>>>> b4d8b1a360012783ee10b0643241cbb880fe64bf


    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser){

        User user = userService.updateUser(id, updatedUser);
        return ResponseEntity.ok(updatedUser);
    }
}
