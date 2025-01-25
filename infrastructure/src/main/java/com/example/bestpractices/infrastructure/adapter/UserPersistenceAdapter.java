package com.example.bestpractices.infrastructure.adapter;

import com.example.bestpractices.infrastructure.entity.UserEntity;
import com.example.bestpractices.infrastructure.mapper.UserEntityMapper;
import com.example.bestpractices.infrastructure.repository.UserRepository;
import com.example.bestpractices.port.dto.UserDto;
import com.example.bestpractices.port.output.UserRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserPersistenceAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;

    public UserPersistenceAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(UserEntityMapper::toDto);
    }

    @Override
    public String save(UserDto userDto) {
        UserEntity userEntity = userRepository.save(UserEntityMapper.toEntity(userDto));
        return userEntity.getEmail();
    }


    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }
}
