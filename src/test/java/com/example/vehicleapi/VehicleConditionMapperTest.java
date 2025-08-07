package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.model.VehicleCondition;
import com.example.vehicleapi.mapper.VehicleConditionMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleConditionMapperTest {
    private final VehicleConditionMapper mapper = Mappers.getMapper(VehicleConditionMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleCondition entity = new VehicleCondition();
        // Optionally set fields here
        VehicleConditionDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        VehicleCondition entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
