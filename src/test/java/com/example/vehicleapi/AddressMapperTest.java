package com.example.vehicleapi;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.model.Address;
import com.example.vehicleapi.mapper.AddressMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class AddressMapperTest {
    private final AddressMapper mapper = Mappers.getMapper(AddressMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        Address entity = new Address();
        // Optionally set fields here
        AddressDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        Address entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
