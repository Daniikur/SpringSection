package com.example.controller;


import com.example.model.Users;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login() {
        return "Login successful!";
    }
}