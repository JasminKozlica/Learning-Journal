package com.example.demo;


import com.example.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser =  userService.createUser(new UserDto());
        return ResponseEntity.ok(savedUser);

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){

        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }


    @GetMapping("/id")
    public ResponseEntity<User> findUserById(@PathVariable Long id){

        User user = userService.findUserById(Long id);
                return ResponseEntity.ok(user);
    }


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
