package com.fsb.gestion_restaurant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import ch.qos.logback.core.model.Model;


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
