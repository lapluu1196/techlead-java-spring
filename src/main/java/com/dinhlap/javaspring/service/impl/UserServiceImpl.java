package com.dinhlap.javaspring.service.impl;

import com.dinhlap.javaspring.dto.user.UserResponse;
import com.dinhlap.javaspring.entity.Role;
import com.dinhlap.javaspring.entity.User;
import com.dinhlap.javaspring.repository.RoleRepository;
import com.dinhlap.javaspring.repository.UserRepository;
import com.dinhlap.javaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserResponse getUserByEmail(String email) {
        User user =  userRepository.findByEmail(email).orElse(null);
        assert user != null;
        return new UserResponse(user.getUserId(), user.getUsername(), user.getEmail(), user.getRoles().stream().map(Role::getRoleName).toList());
    }

    @Override
    public UserResponse saveUser(String username, String email, String password, List<String> roles) {
        if (userRepository.findByEmail(email).isPresent() || userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Email or username already exists");
        }

        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setEnabled(true);

        roles.forEach(role -> {
            roleRepository.findByRoleName(role).ifPresent(role1 -> newUser.getRoles().add(role1));
        });

        User user = userRepository.save(newUser);

        return new UserResponse(user.getUserId(), user.getUsername(), user.getEmail(), user.getRoles().stream().map(Role::getRoleName).toList());
    }
}
