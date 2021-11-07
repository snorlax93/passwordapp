package com.snorlax93.passwordapp.repository;

import com.snorlax93.passwordapp.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
