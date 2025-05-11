package com.fsb.gestion_restaurant.web.controllers;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsb.gestion_restaurant.business.service.UserService;
import com.fsb.gestion_restaurant.dao.models.User;


@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public String getProfile(@PathVariable("id") Long id,Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        return "profile";
    }
    @GetMapping("/{id}/update")
    public String updateProfile(@PathVariable("id") Long id,Model model) {
        model.addAttribute("user", userService.getUserById(id).get());
        return "updateProfile";
    }
    @PostMapping("/{id}/update")
public String updateProfile(
        @PathVariable("id") Long id,
        @RequestParam("username") String username,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("phone") String phone,
        Model model) {
    
    Optional<User> userOptional = userService.getUserById(id);
    
    if (userOptional.isPresent()) {
        User updatedUser = userOptional.get();
        
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);
        updatedUser.setPhone(phone);
        
        // Hash the new password received from the form (not the old one)
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        updatedUser.setPassword(hashedPassword);
        
        userService.updateUser(updatedUser);
        model.addAttribute("user", updatedUser);
        
        return "profile";
    } else {
        return "error";
    }
}
    @GetMapping("/{id}/delete")
    public String deleteProfile(@PathVariable("id") Long id,Model model) {
        userService.deleteUser(id);
        return "redirect:/register";

    }
    @RequestMapping("/{id}/update/admin")
public String updateProfileAdmin(
        @PathVariable("id") Long id,
        @RequestParam("username") String username,
        @RequestParam("email") String email,
        @RequestParam("password") String password,
        @RequestParam("phone") String phone,
        Model model) {
    
    Optional<User> userOptional = userService.getUserById(id);
    
    if (userOptional.isPresent()) {
        User updatedUser = userOptional.get();
        
        updatedUser.setUsername(username);
        updatedUser.setEmail(email);
        updatedUser.setPhone(phone);
        
        // Hash the new password received from the form (not the old one)
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        updatedUser.setPassword(hashedPassword);
        
        userService.updateUser(updatedUser);
        model.addAttribute("user", updatedUser);
        
        return "adminDashboard";
    } else {
        return "error";
    }
}
    @GetMapping("/{id}/delete/admin")
    public String deleteProfileAdmin(@PathVariable("id") Long id,Model model) {
        userService.deleteUser(id);
        return "redirect:/admin";

    }
}
    

