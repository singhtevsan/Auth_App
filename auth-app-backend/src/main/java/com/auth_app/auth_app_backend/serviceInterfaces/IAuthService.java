package com.auth_app.auth_app_backend.serviceInterfaces;

import com.auth_app.auth_app_backend.dtos.UserDto;

public interface IAuthService {
    UserDto registerUser(UserDto userDto);
    UserDto loginUser(UserDto userDto);
}
