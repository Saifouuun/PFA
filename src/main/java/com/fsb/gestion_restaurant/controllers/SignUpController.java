package com.fsb.gestion_restaurant.controllers;


import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fsb.gestion_restaurant.models.Role;
import com.fsb.gestion_restaurant.models.User;
import com.fsb.gestion_restaurant.repository.UserRepository;



@Controller
@RequestMapping("/register")
public class SignUpController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String getRegisterPage(){
        return "register";
    }
    /*@PostMapping
    public @ResponseBody String createClient(@RequestBody User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setPhone(user.getPhone());
        newUser.setUsername(user.getUsername());
        newUser.setRole(Role.CLIENT);
        Optional<User> userEntry = userRepository.findByEmail(newUser.getEmail());
        System.err.println(userEntry);
        if (userEntry.isPresent()) {
            return "Email already existe try another one";
        }
        
        userRepository.save(newUser);
        return "user saved";
    }*/
    @PostMapping
    public String createClient(
        @RequestParam String username, 
        @RequestParam String email, 
        @RequestParam String password, 
        @RequestParam(required = false) String phone,
        @RequestParam String role,Model model) {

    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
    User newUser = new User();
    newUser.setEmail(email);
    newUser.setPassword(hashedPassword);
    newUser.setPhone(phone);
    newUser.setUsername(username);
    if(role.equalsIgnoreCase("Client")){
        newUser.setRole(Role.CLIENT);
    }else{
        newUser.setRole(Role.OWNER);
    }
    
   

    Optional<User> userEntry = userRepository.findByEmail(newUser.getEmail());
    if (userEntry.isPresent()) {
        model.addAttribute("error","Email already existe try another one" );
        return "register";
    }

    userRepository.save(newUser);
    model.addAttribute("success", "User saved successfully");
    return "login";
}
    @PostMapping("/admin")
    public  String createAdmin(@RequestBody User user){
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setPhone(user.getPhone());
        newUser.setUsername(user.getUsername());
        newUser.setRole(Role.ADMIN);
        Optional<User> userEntry = userRepository.findByEmail(newUser.getEmail());
        System.err.println(userEntry);
        if (userEntry.isPresent()) {
            return "register";
        }
        
        userRepository.save(newUser);
        return "login";
    }
}
