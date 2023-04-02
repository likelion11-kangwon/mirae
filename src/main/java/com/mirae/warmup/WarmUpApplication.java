package com.mirae.warmup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class WarmUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(WarmUpApplication.class, args);
    }

}
