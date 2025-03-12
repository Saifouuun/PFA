package com.fsb.gestion_restaurant.controllers;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.UserRepository;


import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/login")
public class LoginCntroller {

    @Autowired
    UserRepository userRepository;

    
    @GetMapping
    public String getLoginPage(){
        return "login";
    }
    @PostMapping
    public ResponseEntity<String> getParam(@RequestParam String email,
                            @RequestParam String password,Model model){
        Optional<User> userOpt = userRepository.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if(BCrypt.checkpw(password, user.getPassword())){
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                user.setPassword(hashedPassword);
                userRepository.save(user);
                return ResponseEntity.status(HttpStatus.OK).body("Login successful");
            }
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorret password");
            
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Email not found");

    }







}
