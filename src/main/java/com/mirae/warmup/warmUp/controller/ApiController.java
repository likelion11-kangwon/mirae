package com.mirae.warmup.warmUp.controller;

import com.nimbusds.common.contenttype.ContentType;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    http://localhost:8080/swagger-ui.html 로 접속하시면 컨트롤러 시험 운용 가능하십니다.
 */
@RestController
@RequestMapping("/mirae")
public class ApiController {
    @Autowired
    private Environment env;

    @GetMapping(value = {"/api/commit_rank"})
    public @ResponseBody List<Map<String, Object>> commitRank() {
        String githubToken = env.getProperty("spring.security.github.token");

        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = RequestBody.create("{}", MediaType.get(ContentType.APPLICATION_JSON.getType()));
        Request request = new Request.Builder()
                .url("https://api.github.com/graphql")
                .post(requestBody)
                .addHeader("Authorization", String.format("Bearer %s", githubToken))
                .build();
        try (Response response = client.newCall(request).execute()){
            response.body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Map<String, Object>> members = new ArrayList<>();
        Map<String, Object> member = new HashMap<>();
        member.put("id", env.getProperty("spring.security.github.token"));
        members.add(member);

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
