package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.model.Vehicle;
import com.example.vehicleapi.mapper.VehicleMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleMapperTest {
    private final VehicleMapper mapper = Mappers.getMapper(VehicleMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        Vehicle entity = new Vehicle();
        // Optionally set fields here
        VehicleDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        Vehicle entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
