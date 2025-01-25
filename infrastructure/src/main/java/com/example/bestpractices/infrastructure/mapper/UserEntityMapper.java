package com.example.bestpractices.infrastructure.mapper;

import com.example.bestpractices.infrastructure.entity.AddressEntity;
import com.example.bestpractices.infrastructure.entity.UserEntity;
import com.example.bestpractices.port.dto.AddressDto;
import com.example.bestpractices.port.dto.UserDto;

import java.util.stream.Collectors;

public class UserEntityMapper {

    public static UserEntity toEntity(UserDto dto) {
        UserEntity entity = new UserEntity();
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());
        entity.setAddresses(dto.getAddresses().stream()
                .map(UserEntityMapper::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }

    public static UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        dto.setAddresses(entity.getAddresses().stream()
                .map(UserEntityMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }

    private static AddressEntity toEntity(AddressDto dto) {
        AddressEntity entity = new AddressEntity();
        entity.setStreetAddress(dto.getStreetAddress());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setZip(dto.getZip());
        return entity;
    }

    private static AddressDto toDto(AddressEntity entity) {
        AddressDto dto = new AddressDto();
        dto.setStreetAddress(entity.getStreetAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZip(entity.getZip());
        return dto;
    }
}
