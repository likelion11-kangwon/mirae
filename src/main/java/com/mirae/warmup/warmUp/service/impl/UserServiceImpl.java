package com.mirae.warmup.warmUp.service.impl;

import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;
import com.mirae.warmup.warmUp.repository.UserRepository;
import com.mirae.warmup.warmUp.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto getUser(String name) {
        User userEntity = userRepository.findByUsername(name);
        UserDto userDto = UserDto.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .email(userEntity.getEmail())
                .role(userEntity.getRole())
                .provider(userEntity.getProvider())
                .providerId(userEntity.getProviderId())
                .age(userEntity.getAge())
                .build();
        return userDto;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .age(userDto.getAge())
                .provider(userDto.getProvider())
                .providerId(userDto.getProviderId())
                .role(userDto.getRole())
                .build();

        String rawPassword = userDto.getPassword();
        String newPasswrod = bCryptPasswordEncoder.encode(rawPassword);

        user.setPassword(newPasswrod);
        user.setRole("ROLE_USER");

        userRepository.save(user);
    }
}
