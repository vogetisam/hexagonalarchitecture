package com.example.bestpractices.adapter.service;

import com.example.bestpractices.adapter.mapper.UserMapper;
import com.example.bestpractices.domain.User;
import com.example.bestpractices.port.dto.UserDto;
import com.example.bestpractices.port.exception.UserNotFoundException;
import com.example.bestpractices.port.input.UserService;
import com.example.bestpractices.port.output.UserRepositoryPort;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryPort userRepositoryPort;

    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepositoryPort.findByEmail(email)
                .map(UserMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
        return UserMapper.toDto(user);
    }

    @Override
    public UserDto editUser(String email, UserDto updatedUserDto) {
        User user = userRepositoryPort.findByEmail(email)
                .map(UserMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

        // Update domain object
        user.updateFirstName(updatedUserDto.getFirstName());
        user.updateLastName(updatedUserDto.getLastName());
        user.updatePhoneNumber(updatedUserDto.getPhoneNumber());


        // Save updated user
        userRepositoryPort.save(UserMapper.toDto(user));
        return UserMapper.toDto(user);
    }

    @Override
    public UserDto updateAddress(String email, UserDto updatedUserDto) {
        User user = userRepositoryPort.findByEmail(email)
                .map(UserMapper::toDomain)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));

        user.getAddresses().clear();
        updatedUserDto.getAddresses().forEach(addressDto -> user.addAddress(UserMapper.toDomain(addressDto)));

        userRepositoryPort.save(UserMapper.toDto(user));
        return UserMapper.toDto(user);
    }

    @Override
    public void deleteUser(String email) {
        if (userRepositoryPort.findByEmail(email).isPresent()) {
            userRepositoryPort.deleteByEmail(email);
        } else {
            throw new UserNotFoundException("User not found with email: " + email);
        }
    }

    @Override
    public String saveUser(UserDto userDto) {
        if (userRepositoryPort.findByEmail(userDto.getEmail()).isPresent()) {
            throw new UserNotFoundException("User not found with email: " + userDto.getEmail());
        }
        return userRepositoryPort.save(userDto);
    }
}
