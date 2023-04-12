package com.mirae.warmup.warmUp.controller;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    http://localhost:8080/swagger-ui.html 로 접속하시면 컨트롤러 시험 운용 가능하십니다.
 */
@Controller
@RequestMapping("/mirae")
public class MemberController {

    @GetMapping({"/user/yong_hyun"})
    public String yong_hyun(@AuthenticationPrincipal PrincipalDetails principalDetails){
        return "team/yong_hyun";
    }

    @GetMapping("/user/jihye/1")
    public String jihye1(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/jihye/index1";
    }

    @GetMapping("/user/jihye/2")
    public String jihye2(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/jihye/index2";
    }

    @GetMapping("/user/jihye/3")
    public String jihye3(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/jihye/index3";
    }

    @GetMapping("/user/jihye/4")
    public String jihye4(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/jihye/index4";
    }

    @GetMapping("/user/jihye/5")
    public String jihye5(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/jihye/index5";
    }

    @GetMapping("/user/chanwoo")
    public String chanwoo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/chanwoo";
    }


    @GetMapping("/user/yoonsoo")
    public String yoonsoo(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails: " + principalDetails);
        return "team/yoonsoo";
    }
}
