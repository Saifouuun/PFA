package com.fsb.gestion_restaurant.controllers;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.UserRepository;



@Controller
@RequestMapping("/login")
public class LoginCntroller {

    @Autowired
    UserRepository userRepository;

    
    @GetMapping
    public String getLoginPage(){
        return "login";
    }
    /*@PostMapping
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

    }*/
    @PostMapping
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







}
