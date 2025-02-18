package com.practice.HRAnalytics.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.HRAnalytics.model.User;
import com.practice.HRAnalytics.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public AuthService(){
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    private static final String SECRET_KEY = "com_practice_secre_key".repeat(20);
    private static final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public User register(User user) {
        String hashPassword = bCryptPasswordEncoder.encode(user.getPassword());
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setUserId(user.getUserId());
        newUser.setPassword(hashPassword);

        return this.userRepository.save(newUser);
    }

    public String login(String userId, String password) {
        User user = this.userRepository.findByUserId(userId).orElse(null);
        if (user == null) {
            return "User not found";
        }
        if (!this.bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return "Incorrect Password";
        }
        System.out.println(user);
        return generateJwt(user);

    }

    private String generateJwt(User user) {
        return Jwts.builder().subject(user.getUserId()).issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000)).signWith(key).compact();
    }

}
