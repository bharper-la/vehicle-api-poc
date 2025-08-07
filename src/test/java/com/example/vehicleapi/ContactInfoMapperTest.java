package com.example.vehicleapi;

import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.model.ContactInfo;
import com.example.vehicleapi.mapper.ContactInfoMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class ContactInfoMapperTest {
    private final ContactInfoMapper mapper = Mappers.getMapper(ContactInfoMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        ContactInfo entity = new ContactInfo();
        // Optionally set fields here
        ContactInfoDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        ContactInfo entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
