package com.mirae.warmup.warmUp.controller;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;
import com.mirae.warmup.warmUp.repository.UserRepository;
import com.mirae.warmup.warmUp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
    http://localhost:8080/swagger-ui.html 로 접속하시면 컨트롤러 시험 운용 가능하십니다.
 */
@Controller
@RequestMapping("/mirae")
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping({"home", "/"})
    public String home(){
        return "index";
    }

    @GetMapping("/user/yoonsoo")
    public @ResponseBody String yoonsoo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "yoonsoo";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin(){
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager(){
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
