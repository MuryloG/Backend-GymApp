package com.gymapp.backend.controller;

import com.gymapp.backend.model.User;
import com.gymapp.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User loginData) {
        return userService.findByEmail(loginData.getEmail())
                .filter(user -> user.getPassword().equals(loginData.getPassword()))
                .orElse(null);
    }
}
