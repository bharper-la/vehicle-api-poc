package com.example.vehicleapi;

import com.example.vehicleapi.dto.UserDto;
import com.example.vehicleapi.model.User;
import com.example.vehicleapi.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class UserMapperTest {
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        User entity = new User();
        // Optionally set fields here
        UserDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        User entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
