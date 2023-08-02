package com.example.usermanagementservice.service;

import com.example.usermanagementservice.dto.UserDTO;
import com.example.usermanagementservice.exceptions.UserNotFoundException;
import com.example.usermanagementservice.mapper.UserMapper;
import com.example.usermanagementservice.model.User;
import com.example.usermanagementservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDTO> readAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();
        users.forEach(user -> userDTOs.add(userMapper.mapToDTO(user)));
        return userDTOs;
    }

    public UserDTO readUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return userMapper.mapToDTO(user.get());
        } else {
            throw new UserNotFoundException("User not found!");
        }
    }

    public UserDTO createUser(User user) {
        User newUser = userRepository.save(user);
        return userMapper.mapToDTO(newUser);
    }

}
