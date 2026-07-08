package com.auth_app.auth_app_backend.services;

import com.auth_app.auth_app_backend.dtos.UserDto;
import com.auth_app.auth_app_backend.entities.User;
import com.auth_app.auth_app_backend.exceptions.ResourceNotFoundException;
import com.auth_app.auth_app_backend.repositories.UserRepository;
import com.auth_app.auth_app_backend.serviceInterfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {

        if(userDto.getEmail() == null || userDto.getEmail().isEmpty()){
            throw new IllegalArgumentException("Email is required");
        }
        else if(userRepository.existsByEmail(userDto.getEmail())){
            throw new IllegalArgumentException("Email already exists");
        }
        else{
            User user = modelMapper.map(userDto, User.class);
            User savedUser = userRepository.save(user);
            return modelMapper.map(savedUser, UserDto.class);
        }
    }

    @Override
    public UserDto updateUser(int id,  UserDto userDto) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if(userDto.getUser()!=null){
            user.setUser(userDto.getUser());
        }
        if(userDto.getPassword()!=null){
            user.setPassword(userDto.getPassword());
        }
        if(userDto.getImage()!=null){
            user.setImage(userDto.getImage());
        }
        if(userDto.getGender()!=null){
            user.setGender(userDto.getGender());
        }
        if(userDto.getProvider()!=null){
            user.setProvider(userDto.getProvider());
        }

        User updatedUser = userRepository.save(user);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User not found with given id"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository
                .findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("User not found with given email"));

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<UserDto> getAllUsers() {
        return
                userRepository
                .findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
    }

    @Override
    public void deleteUser(int id) {
        User user = userRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given id"));

        userRepository.delete(user);
    }
}
