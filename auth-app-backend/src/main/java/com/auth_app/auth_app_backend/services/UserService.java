package com.auth_app.auth_app_backend.services;

import com.auth_app.auth_app_backend.dtos.UserDto;
import com.auth_app.auth_app_backend.serviceInterfaces.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto getUser() {
        return null;
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<UserDto> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(UserDto userDto) {

    }
}
