package com.fsb.gestion_restaurant.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("*")
    public String handleError() {
        return "error";
    }

}
