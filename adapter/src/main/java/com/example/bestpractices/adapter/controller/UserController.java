package com.example.bestpractices.adapter.controller;

import com.example.bestpractices.port.dto.UserDto;
import com.example.bestpractices.port.input.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Use Case 1: View a User by Email
    @GetMapping("/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(userService.getUserByEmail(email));
    }

    // Use Case 2: Edit a User
    @PutMapping("/{email}")
    public ResponseEntity<UserDto> editUser(@PathVariable String email, @RequestBody UserDto updatedUser) {
        return ResponseEntity.ok(userService.editUser(email, updatedUser));
    }

    // Use Case 3: Update Address
    @PatchMapping("/{email}/address")
    public ResponseEntity<UserDto> updateAddress(@PathVariable String email, @RequestBody UserDto updatedAddress) {
        return ResponseEntity.ok(userService.updateAddress(email, updatedAddress));
    }

    // Use Case 4: Delete a User
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }
}