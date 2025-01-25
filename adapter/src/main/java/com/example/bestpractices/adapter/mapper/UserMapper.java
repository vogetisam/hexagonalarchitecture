package com.example.bestpractices.adapter.mapper;

import com.example.bestpractices.port.dto.AddressDto;
import com.example.bestpractices.port.dto.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDto(UserDto userDto) {
        // Map directly since it's already in DTO format
        return userDto;
    }

    public static UserDto fromDomain(UserDto domainUser) {
        UserDto dto = new UserDto();
        dto.setFirstName(domainUser.getFirstName());
        dto.setLastName(domainUser.getLastName());
        dto.setEmail(domainUser.getEmail());
        dto.setAddresses(domainUser.getAddresses());
        return dto;
    }

    public static List<AddressDto> mapAddresses(List<AddressDto> addresses) {
        return addresses.stream()
                .map(address -> {
                    AddressDto dto = new AddressDto();
                    dto.setStreetAddress(address.getStreetAddress());
                    dto.setCity(address.getCity());
                    dto.setState(address.getState());
                    dto.setZip(address.getZip());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
