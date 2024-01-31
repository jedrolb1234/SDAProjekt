package com.example.front.service;

import com.example.front.user.UserEntity;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Optional<List<UserEntity>> findByName(String username);

}
