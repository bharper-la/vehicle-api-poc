package com.example.vehicleapi;

import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.model.Lead;
import com.example.vehicleapi.mapper.LeadMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class LeadMapperTest {
    private final LeadMapper mapper = Mappers.getMapper(LeadMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        Lead entity = new Lead();
        // Optionally set fields here
        LeadDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        Lead entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
