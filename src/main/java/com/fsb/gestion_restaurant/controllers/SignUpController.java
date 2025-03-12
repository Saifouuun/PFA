package com.fsb.gestion_restaurant.controllers;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    public @ResponseBody String createUser(@RequestParam String username,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String phone ){
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User u = new User();
        u.setEmail(email);
        u.setPassword(hashedPassword);
        u.setPhone(phone);
        u.setUsername(username);
        Optional<User> userEntry = userRepository.findByEmail(u.getEmail());
        System.err.println(userEntry);
        if (userEntry.isPresent()) {
            return "Email already existe try another one";
        }
        
        userRepository.save(u);
        return "user saved";
    }
}
