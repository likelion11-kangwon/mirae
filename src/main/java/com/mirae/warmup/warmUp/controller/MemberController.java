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
}
