package com.arifunver.backendwithspring.controller;

import com.arifunver.backendwithspring.model.User;
import com.arifunver.backendwithspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    List<User> getAllUsers() {
        return userService.allUsers();
    }

    @GetMapping("/{userId}")
    User getOneUser(@PathVariable Long userId) {
        return userService.oneUser(userId);

    }
    @PostMapping()
    User newUser(@RequestBody User newUser) {
        return userService.createUser(newUser);

    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);

    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable Long userId, @RequestBody User newUser) {
        return userService.updateUser(userId, newUser);
    }
}
