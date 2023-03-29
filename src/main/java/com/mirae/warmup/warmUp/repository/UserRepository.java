package com.mirae.warmup.warmUp.repository;

import com.mirae.warmup.warmUp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String username);
}
