package com.example.bestpractices.adapter.service;

import com.example.bestpractices.port.dto.UserDto;
import com.example.bestpractices.port.exception.UserNotFoundException;
import com.example.bestpractices.port.input.UserService;
import com.example.bestpractices.port.output.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepositoryPort userRepositoryPort;

    public UserServiceImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return userRepositoryPort.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with email " + email + " not found."));
    }

    @Override
    public UserDto editUser(String email, UserDto updatedUser) {
        UserDto existingUser = getUserByEmail(email); // Fetch existing user or throw exception
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail()); // Update attributes
        userRepositoryPort.save(existingUser); // Persist the changes
        return existingUser;
    }

    @Override
    public UserDto updateAddress(String email, UserDto updatedAddress) {
        UserDto existingUser = getUserByEmail(email); // Fetch existing user or throw exception
        existingUser.setAddresses(updatedAddress.getAddresses()); // Update addresses
        userRepositoryPort.save(existingUser); // Persist the changes
        return existingUser;
    }

    @Override
    public void deleteUser(String email) {
        if (userRepositoryPort.findByEmail(email).isEmpty()) {
            throw new UserNotFoundException("User with email " + email + " not found.");
        }
        userRepositoryPort.deleteByEmail(email);
    }
}
