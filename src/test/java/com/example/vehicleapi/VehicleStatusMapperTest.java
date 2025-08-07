package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.model.VehicleStatus;
import com.example.vehicleapi.mapper.VehicleStatusMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleStatusMapperTest {
    private final VehicleStatusMapper mapper = Mappers.getMapper(VehicleStatusMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleStatus entity = new VehicleStatus();
        // Optionally set fields here
        VehicleStatusDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        VehicleStatus entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
