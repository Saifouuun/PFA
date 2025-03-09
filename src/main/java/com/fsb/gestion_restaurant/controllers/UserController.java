package com.fsb.gestion_restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class UserController {


    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }
    @RequestMapping("/sign")
    public String getSign() {
        return "sign_up";
    }
    
}
