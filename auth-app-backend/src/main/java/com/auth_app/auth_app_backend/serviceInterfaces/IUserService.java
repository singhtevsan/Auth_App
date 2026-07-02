package com.auth_app.auth_app_backend.serviceInterfaces;

import com.auth_app.auth_app_backend.dtos.UserDto;


public interface IUserService {

    UserDto createUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto getUser();
    UserDto getUserById(String id);
    UserDto getUserByEmail(String email);
    Iterable<UserDto> getAllUsers();
    void deleteUser(UserDto userDto);
}
