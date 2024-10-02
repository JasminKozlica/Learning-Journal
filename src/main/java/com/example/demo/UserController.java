package com.example.demo;


import com.example.demo.dto.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private  UserService userService;

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user){
        User savedUser =  userService.createUser(new UserDto(user.getUsername(), user.getEmail(), RoleName.ROLE_STUDENT,user.getPassword()));
        return "redirect:/users/signUpConfirm";
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "signUp";
    }

    @GetMapping("/signUpConfirm")
    public String signUpConfirm(@ModelAttribute User user, Model model) {
        model.addAttribute("user",user);
        return "signUpConfirm";
    }
//    @GetMapping("/id")
//    public ResponseEntity<User> findUserById(@PathVariable Long id){
//        User user = userService.findUserById(Long id);
//                return ResponseEntity.ok(user);
//    }


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
