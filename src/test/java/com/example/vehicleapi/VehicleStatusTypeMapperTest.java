package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.model.VehicleStatusType;
import com.example.vehicleapi.mapper.VehicleStatusTypeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleStatusTypeMapperTest {
    private final VehicleStatusTypeMapper mapper = Mappers.getMapper(VehicleStatusTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleStatusType entity = new VehicleStatusType();
        // Optionally set fields here
        VehicleStatusTypeDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        VehicleStatusType entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
