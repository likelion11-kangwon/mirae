package com.mirae.warmup.warmUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("")
    public String duplicateLogin(){
        return "index";
    }
}
