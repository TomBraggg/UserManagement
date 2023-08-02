package com.example.usermanagementservice.mapper;

import com.example.usermanagementservice.dto.UserDTO;
import com.example.usermanagementservice.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO mapToDTO(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }

    public User mapToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO, User.class);
    }
}
