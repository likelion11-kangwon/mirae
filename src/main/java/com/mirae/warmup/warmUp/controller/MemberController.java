package com.mirae.warmup.warmUp.controller;

import com.mirae.warmup.warmUp.config.auth.PrincipalDetails;
import com.mirae.warmup.warmUp.dto.UserDto;
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
public class MemberController {

    @GetMapping({"/team/yong_hyun"})
    public String home(){

        return "team/yong_hyun";
    }
}
