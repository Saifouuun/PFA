package com.fsb.gestion_restaurant.controllers;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.UserRepository;



@Controller
@RequestMapping("/sign")
public class SignUpController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getSignPage(){
        return "sign_up";
    }
    @PostMapping
    
    public @ResponseBody String createUser(@RequestBody User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setPhone(user.getPhone());
        newUser.setUsername(user.getUsername());
        Optional<User> userEntry = userRepository.findByEmail(newUser.getEmail());
        System.err.println(userEntry);
        if (userEntry.isPresent()) {
            return "Email already existe try another one";
        }
        
        userRepository.save(newUser);
        return "user saved";
    }
}
