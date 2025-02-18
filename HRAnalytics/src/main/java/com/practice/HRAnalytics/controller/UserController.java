package com.practice.HRAnalytics.controller;

import org.springframework.web.bind.annotation.RestController;

import com.practice.HRAnalytics.model.User;
import com.practice.HRAnalytics.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class UserController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User postMethodName(@RequestBody User user) {
        return authService.register(user);
    }

    @GetMapping("/login")
    public String getMethodName(@RequestParam String userId, @RequestParam String password) {
        
        return authService.login(userId, password);
    }
    
    
}
