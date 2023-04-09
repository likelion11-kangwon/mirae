package com.mirae.warmup.warmUp.controller;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mirae")
public class JihyeController {
    @GetMapping("/user/jihye/1")
    public String jihye1(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "jihye/index1";
    }

    @GetMapping("/user/jihye/2")
    public String jihye2(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "jihye/index2";
    }

    @GetMapping("/user/jihye/3")
    public String jihye3(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "jihye/index3";
    }

    @GetMapping("/user/jihye/4")
    public String jihye4(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "jihye/index4";
    }

    @GetMapping("/user/jihye/5")
    public String jihye5(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "jihye/index5";
    }
}
