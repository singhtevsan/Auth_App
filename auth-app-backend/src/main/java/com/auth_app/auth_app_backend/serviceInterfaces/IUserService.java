package com.auth_app.auth_app_backend.serviceInterfaces;

import com.auth_app.auth_app_backend.dtos.UserDto;


public interface IUserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(int id, UserDto userDto);
    UserDto getUserById(int id);
    UserDto getUserByEmail(String email);
    Iterable<UserDto> getAllUsers();
    void deleteUser(int id);
}
