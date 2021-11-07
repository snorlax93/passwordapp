package com.snorlax93.passwordapp.service;

import java.util.List;

import com.snorlax93.passwordapp.model.User;

public interface UserService {
    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long uid);
    void deleteUserById(long uid);
}
