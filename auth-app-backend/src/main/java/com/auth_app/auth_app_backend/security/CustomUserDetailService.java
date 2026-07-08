package com.auth_app.auth_app_backend.security;

import com.auth_app.auth_app_backend.entities.User;
import com.auth_app.auth_app_backend.exceptions.ResourceNotFoundException;
import com.auth_app.auth_app_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password"));

        return user;
    }
}
