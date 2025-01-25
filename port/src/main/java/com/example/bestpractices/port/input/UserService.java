package com.example.bestpractices.port.input;


import com.example.bestpractices.port.dto.UserDto;

public interface UserService {
    // Use Case 1: View User
    UserDto getUserByEmail(String email);

    // Use Case 2: Edit User
    UserDto editUser(String email, UserDto updatedUser);

    // Use Case 3: Update Address
    UserDto updateAddress(String email, UserDto updatedAddress);

    // Use Case 4: Delete User
    void deleteUser(String email);
}
