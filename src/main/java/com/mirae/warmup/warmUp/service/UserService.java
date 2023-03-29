package com.mirae.warmup.warmUp.service;

import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;

public interface UserService {
    public UserDto getUser(String name);
    public UserDto saveUser(UserDto userDto);
}
