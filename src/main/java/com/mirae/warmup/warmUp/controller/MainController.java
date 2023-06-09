package com.mirae.warmup.warmUp.controller;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mirae")
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping({"home", ""})
    public String home(@AuthenticationPrincipal PrincipalDetails principalDetails, Model model) {
        model.addAttribute("login", principalDetails == null);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join")
    public String join(UserDto userDto){
        System.out.println(userDto);

        if(userService.getUserDto(userDto.getUsername()) == null) {
            userService.saveUserDto(userDto);
            System.out.println("success");
        }

        return "redirect:/mirae/loginForm";
    }
}
