package com.auth_app.auth_app_backend.services;

import com.auth_app.auth_app_backend.dtos.UserDto;
import com.auth_app.auth_app_backend.serviceInterfaces.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userDto) {

        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        UserDto dto = userService.createUser(userDto);
        return dto;
    }

    @Override
    public UserDto loginUser(UserDto userDto) {
        return null;
    }
}
