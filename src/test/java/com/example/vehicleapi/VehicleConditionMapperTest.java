package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.model.Vehicle;
import com.example.vehicleapi.model.VehicleCondition;
import com.example.vehicleapi.model.VehicleConditionType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleConditionMapperTest {

    private final VehicleConditionMapper mapper = Mappers.getMapper(VehicleConditionMapper.class);
    private final VehicleConditionTypeMapper typeMapper = Mappers.getMapper(VehicleConditionTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleConditionType type = VehicleConditionType.builder()
                .id(1)
                .code("EXCELLENT")
                .description("Excellent condition")
                .build();

        VehicleCondition condition = VehicleCondition.builder()
                .id(10)
                .vehicle(Vehicle.builder().id(5).build())
                .conditionType(type)
                .conditionDate(LocalDate.now())
                .comments("Clean inside and out")
                .build();

        VehicleConditionDto dto = mapper.toDto(condition);
        assertEquals("EXCELLENT", dto.getConditionType().getCode());

        VehicleCondition roundTrip = mapper.toEntity(dto);
        assertEquals("EXCELLENT", roundTrip.getConditionType().getCode());
    }
}