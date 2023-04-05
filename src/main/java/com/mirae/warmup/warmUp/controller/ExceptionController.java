package com.mirae.warmup.warmUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {
    @GetMapping("")
    public String duplicateLogin(){
        return "index";
    }

    @GetMapping("error403")
    public String error403(){
        return "error403";
    }
}
