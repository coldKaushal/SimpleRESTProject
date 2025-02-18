package com.practice.HRAnalytics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.HRAnalytics.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findByUserId(String userid);
}
