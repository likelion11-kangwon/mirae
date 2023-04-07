package com.mirae.warmup.warmUp.service;

import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;

public interface UserService {
    public UserDto getUserDto(String username);

    public User getUserEntity(String username);
    public void saveUserDto(UserDto userDto);

    public void saveUserEntity(User user);

}
