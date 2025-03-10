package com.fsb.gestion_restaurant.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }
    @RequestMapping("/sign")
    public String getSign() {
        return "sign_up";
    }
  
    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    
}
