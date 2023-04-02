package com.mirae.warmup.warmUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.*;

/*
    http://localhost:8080/swagger-ui.html 로 접속하시면 컨트롤러 시험 운용 가능하십니다.
 */
@RestController
@RequestMapping("/mirae")
public class ApiController {

    @GetMapping(value = {"/api/commit_rank"})
    public @ResponseBody List<Map<String, Object>> commitRank() {
        List<Map<String, Object>> members = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            Map<String, Object> member = new HashMap<>();
            member.put("id", i);
            member.put("name", i + "번 개발자");
            member.put("age", 10 + i);
            members.add(member);
        }
        return members;
        // 위에 있는 소스코드는 테스트 (실습)
        /* [{
            "member": "gunyu1019",
            "url": "https://github.com/gunyu1019/",
            "commits": 60,
            "avatar": "AVATAR_URL"
        }, x 25개] */
    }
}
