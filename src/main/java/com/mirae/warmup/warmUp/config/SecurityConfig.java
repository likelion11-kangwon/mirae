package com.mirae.warmup.warmUp.config;

import com.mirae.warmup.warmUp.config.oauth.PrincipalOAuth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private PrincipalOAuth2UserService principalOAuth2UserService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/mirae/user/**").authenticated()
                .antMatchers("/mirae/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/mirae/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/mirae/loginForm")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/mirae")
                .and()
                .oauth2Login()
                .loginPage("/mirae/loginForm")
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);
        return http.build();
    }
}
