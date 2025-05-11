package com.fsb.gestion_restaurant.web.controllers;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsb.gestion_restaurant.business.service.UserService;
import com.fsb.gestion_restaurant.dao.models.User;
import com.fsb.gestion_restaurant.dao.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @GetMapping("/all")
    public @ResponseBody List<User> getALLUsers(){
        List<User> user = userRepository.findAll();
        return user;
    }
    

 
    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
    @GetMapping("/profile/{id}/update")
    public String updateProfile(@PathVariable("id") Long id,Model model) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "updateProfile";
        } else {
            return "error"; 
        }
    }
    


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
