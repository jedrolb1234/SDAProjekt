package com.example.front.service.impl;

import com.example.front.repository.UserRepository;
import com.example.front.user.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService implements com.example.front.service.AdminService {
    UserRepository userRepository;
    Optional<List<UserEntity>> users;
    public AdminService(UserRepository user) {
        this.userRepository = user;
    }

    public Optional<List<UserEntity>> findByName(String username){
        List<UserEntity> users = userRepository.findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList());
        return Optional.ofNullable(users);
        };


}
