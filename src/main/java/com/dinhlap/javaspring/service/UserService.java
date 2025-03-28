package com.dinhlap.javaspring.service;

import com.dinhlap.javaspring.dto.user.UserResponse;
import com.dinhlap.javaspring.entity.User;

import java.util.List;

public interface UserService {
    UserResponse getUserByEmail(String email);
    UserResponse saveUser(String username, String email, String password, List<String> roles);
}
