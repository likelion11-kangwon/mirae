package com.mirae.warmup.warmUp.service.impl;

import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;
import com.mirae.warmup.warmUp.repository.UserRepository;
import com.mirae.warmup.warmUp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUser(String name) {
        User userEntity = userRepository.findByUsername(name);
        UserDto userDto = new UserDto(userEntity.getUsername(), userEntity.getAge(), userEntity.getEmail());
        return userDto;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {

        return null;
    }
}
