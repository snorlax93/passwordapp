package com.snorlax93.passwordapp.service.impl;

import java.util.List;
import java.util.Optional;

import com.snorlax93.passwordapp.model.User;
import com.snorlax93.passwordapp.repository.UserRepository;
import com.snorlax93.passwordapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
        
    }

    @Override
    public User getUserById(long uid) {
        Optional<User> optional = userRepository.findById(uid);
        User user = null;
        if (optional.isPresent()) {
            user = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + uid);
        }
        return user;
    }

    @Override
    public void deleteUserById(long uid) {
        this.userRepository.deleteById(uid);
        
    }
    
}
