package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.model.VehicleConditionType;
import com.example.vehicleapi.mapper.VehicleConditionTypeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleConditionTypeMapperTest {
    private final VehicleConditionTypeMapper mapper = Mappers.getMapper(VehicleConditionTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleConditionType entity = new VehicleConditionType();
        // Optionally set fields here
        VehicleConditionTypeDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        VehicleConditionType entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
