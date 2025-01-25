package com.example.bestpractices.adapter.mapper;

import com.example.bestpractices.domain.User;
import com.example.bestpractices.domain.Address;
import com.example.bestpractices.port.dto.UserDto;
import com.example.bestpractices.port.dto.AddressDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    // Convert UserDto to User (DTO -> Domain)
    public static User toDomain(UserDto dto) {
        User user = new User(dto.getEmail(), dto.getFirstName(), dto.getLastName());
        user.updatePhoneNumber(dto.getPhoneNumber());
        List<Address> addresses = dto.getAddresses()
                .stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
        addresses.forEach(user::addAddress);
        return user;
    }

    // Convert User to UserDto (Domain -> DTO)
    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setAddresses(user.getAddresses()
                .stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList()));
        return dto;
    }

    // Convert AddressDto to Address (DTO -> Domain)
    public static Address toDomain(AddressDto dto) {
        return new Address(dto.getStreetAddress(), dto.getDoorNumber(),dto.getLocality(),dto.getCity(),dto.getCountry(), dto.getState(), dto.getZip());
    }

    // Convert Address to AddressDto (Domain -> DTO)
    private static AddressDto toDto(Address domain) {
        AddressDto dto = new AddressDto();
        dto.setStreetAddress(domain.getStreetAddress());
        dto.setCity(domain.getCity());
        dto.setState(domain.getState());
        dto.setZip(domain.getZip());
        return dto;
    }
}
