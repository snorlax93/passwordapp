package com.snorlax93.passwordapp.controller;

import com.snorlax93.passwordapp.model.User;
import com.snorlax93.passwordapp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserService UserService;

    @GetMapping("/user")
    public String userIndex(Model model) {
        model.addAttribute("users", UserService.getAllUsers());
        return "userIndex";
    }

    @GetMapping("/user/new")
    public String newUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "newUserForm";
    }

    @PostMapping("/user/save")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        UserService.saveUser(user);
        model.addAttribute("user", user);
        return "newUserConfirm";
    }

    @GetMapping("/user/{uid}/update")
    public String updateUser(@PathVariable(value = "uid") long uid, Model model) {
        User user = UserService.getUserById(uid);
        model.addAttribute("user", user);
        return "updateUserForm";
    }

    @GetMapping("/user/{uid}/delete")
    public String deleteUser(@PathVariable(value = "uid") long uid, Model model) {
        User user = UserService.getUserById(uid);
        this.UserService.deleteUserById(uid);
        model.addAttribute("user", user);
        return "deleteUserconfirm";
    }
}
