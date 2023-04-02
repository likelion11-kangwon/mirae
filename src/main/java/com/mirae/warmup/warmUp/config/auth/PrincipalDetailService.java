package com.mirae.warmup.warmUp.config.auth;

import com.mirae.warmup.warmUp.dto.UserDto;
import com.mirae.warmup.warmUp.entity.User;
import com.mirae.warmup.warmUp.repository.UserRepository;
import com.mirae.warmup.warmUp.service.UserService;
import com.mirae.warmup.warmUp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Enumeration;

@Service
public class PrincipalDetailService implements UserDetailsService {

    private final UserService userService;

    public PrincipalDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.getUserEntity(username);

        System.out.println("user: " + userEntity);
        System.out.println(userEntity.getUsername());

        if(userEntity != null)
            return new PrincipalDetails(userEntity);
        return null;
    }
}
