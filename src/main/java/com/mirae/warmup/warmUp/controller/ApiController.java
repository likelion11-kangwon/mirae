package com.mirae.warmup.warmUp.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.mirae.warmup.warmUp.dto.ContributionsCollectionDto;
import com.mirae.warmup.warmUp.dto.GithubOrganzationUserDto;
import com.mirae.warmup.warmUp.dto.GithubUserDto;
import okhttp3.*;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.*;

/*
    http://localhost:8080/swagger-ui.html 로 접속하시면 컨트롤러 시험 운용 가능하십니다.
 */
@RestController
@RequestMapping("/mirae")
public class ApiController {
    private final Environment env;

    public ApiController(Environment env) {
        this.env = env;
    }

    @GetMapping(value = {"/api/commit_rank"})
    public @ResponseBody List<Map<String, Object>> commitRank() {
        String githubToken = env.getProperty("spring.security.github.token");
        List<Map<String, Object>> members = new ArrayList<>();

        Gson gson = new Gson();
        OkHttpClient client = new OkHttpClient();
        Request request1 = new Request.Builder()
                .url("https://api.github.com/orgs/likelion11-kangwon/members")
                .addHeader("Authorization", String.format("Bearer %s", githubToken))
                .build();
        Type listOfGithubOrganzationUser = new TypeToken<ArrayList<GithubOrganzationUserDto>>() {}.getType();
        ArrayList<GithubOrganzationUserDto> organzationMember;
        try (Response response = client.newCall(request1).execute()){
            organzationMember = gson.fromJson(Objects.requireNonNull(response.body()).string(), listOfGithubOrganzationUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (GithubOrganzationUserDto member : organzationMember) {
            Map<String, Object> data = new HashMap<>();
            data.put("login", member.login);
            data.put("avatar", member.avatar_url);

            String query = "query userInfo ($login: String!, $from: DateTime, $to: DateTime) { user (login: $login) { name contributionsCollection(from: $from, to: $to) { totalCommitContributions restrictedContributionsCount }}}";
            String variables = "{\"login\": \"" + member.login + "\", \"from\": \"2023-03-01T00:00:00Z\", \"to\": \"2023-04-01T00:00:00Z\"}";
            String requestJson = "{\"query\": \"" + query + "\", \"variables\": "+ variables + "}";
            // System.out.println(requestJson);
            MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
            RequestBody body = RequestBody.create(requestJson, mediaType);
            Request request2 = new Request.Builder()
                    .url("https://api.github.com/graphql")
                    .post(body)
                    .addHeader("Authorization", String.format("Bearer %s", githubToken))
                    .build();
            GithubUserDto userInfo;
            try (Response response = client.newCall(request2).execute()){
                Map<String, Map<String, Map<String, Object>>> githubData = gson.fromJson(Objects.requireNonNull(response.body()).string(), Map.class);
                // System.out.println(githubData.get("data").get("user").toString());
                // userInfo = gson.fromJson(githubData.get("data").get("user").toString(), GithubUserDto.class);
                String userInfoName = Objects.requireNonNullElse(githubData.get("data").get("user").get("name"), member.login).toString();
                ContributionsCollectionDto contributionsCollection = gson.fromJson(githubData.get("data").get("user").get("contributionsCollection").toString(), ContributionsCollectionDto.class);
                data.put("username", userInfoName);
                data.put("commits", contributionsCollection.totalCommitContributions);
                System.out.println(data);
                members.add(data);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
