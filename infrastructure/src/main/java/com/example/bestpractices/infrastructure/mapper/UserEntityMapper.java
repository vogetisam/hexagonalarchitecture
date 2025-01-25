package com.example.bestpractices.infrastructure.mapper;

import com.example.bestpractices.infrastructure.entity.AddressEntity;
import com.example.bestpractices.infrastructure.entity.UserEntity;
import com.example.bestpractices.port.dto.AddressDto;
import com.example.bestpractices.port.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserEntityMapper {

    public static UserEntity toEntity(UserDto dto) {
        UserEntity user = new UserEntity();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setEmail(dto.getEmail());

        List<AddressEntity> addresses = dto.getAddresses().stream()
                .map(addressDto -> {
                    AddressEntity address = toEntity(addressDto);
                    address.setUser(user); // Set the user association
                    return address;
                })
                .collect(Collectors.toList());

        user.setAddresses(addresses);
        return user;
    }

    public static AddressEntity toEntity(AddressDto dto) {
        AddressEntity address = new AddressEntity();
        address.setStreetAddress(dto.getStreetAddress());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZip(dto.getZip());
        address.setCountry(dto.getCountry());
        address.setLocality(dto.getLocality());
        address.setDoorNumber(String.valueOf(dto.getDoorNumber()));
        return address;
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


    private static AddressDto toDto(AddressEntity entity) {
        AddressDto dto = new AddressDto();
        dto.setStreetAddress(entity.getStreetAddress());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZip(entity.getZip());
        return dto;
    }
}
