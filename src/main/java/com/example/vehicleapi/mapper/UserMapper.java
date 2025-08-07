package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.UserDto;
import com.example.vehicleapi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDto(User entity);
    User toEntity(UserDto dto);
}
