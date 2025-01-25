package com.example.bestpractices.port.output;

import com.example.bestpractices.port.dto.UserDto;

import java.util.Optional;


public interface UserRepositoryPort {
    Optional<UserDto> findByEmail(String email);

    void save(UserDto userDto);

    void deleteByEmail(String email);
}
