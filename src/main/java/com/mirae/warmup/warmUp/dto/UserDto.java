package com.mirae.warmup.warmUp.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto {
    private String username;

    private String password;

    private String email;

    private Integer age;

    private String role;

    private String provider;

    private String providerId;

    private String name;

}
