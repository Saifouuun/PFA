package com.fsb.gestion_restaurant.controllers;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;



@Controller

public class AuthCntroller {

    @Autowired
    UserRepository userRepository;

    
    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }
    @PostMapping("/login")
    public String getParam(@RequestParam String email,
                            @RequestParam String password ,HttpSession session,Model model){
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if(BCrypt.checkpw(password, user.getPassword())){
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                user.setPassword(hashedPassword);
                userRepository.save(user);
                /*return ResponseEntity.status(HttpStatus.OK).body("Login successful");*/
                model.addAttribute("user",user.getUsername());
                session.setAttribute("email", email);
                
                return "dashboard";
            }
            
            /*return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorret password");*/
            model.addAttribute("errorPassword", "Incorrect password");
            return "login";
            
        }
        /*return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");*/
        model.addAttribute("errorEmail", "Email not found");
        return "login";

    }
    @GetMapping("/dashboard")
    public String home(HttpSession session, Model model) {
        String email = (String) session.getAttribute("email");
        if (email == null) {
            return "redirect:/login";  // If user is not logged in, redirect to login page
        }
        model.addAttribute("email", email);
        return "dashboard";  // Return home page
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();  // Invalidate the session
        return "redirect:/login";  // Redirect to login page after logout
    }
    
    @GetMapping("/main")
    public String getHomePage(){
        return "main";
    }
    @GetMapping("/")
    public String getRootPage(){
        return "main";
    }
    
    
    
    
    
    
    
    
    
    
    
    /* login with request body if you use postman for testing
    @PostMapping("/login")
    public ResponseEntity<String> getParam(@RequestBody User user){
        Optional<User> userOpt = userRepository.findByEmail(user.getEmail());
        if (userOpt.isPresent()) {
            User u = userOpt.get();
            if(BCrypt.checkpw(user.getPassword(), u.getPassword())){
                String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
                u.setPassword(hashedPassword);
                userRepository.save(u);
                return ResponseEntity.status(HttpStatus.OK).body("Login successful");
            }
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorret password");
            
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");

    }
*/






}
