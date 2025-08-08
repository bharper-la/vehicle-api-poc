package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.model.Vehicle;
import com.example.vehicleapi.model.VehicleStatus;
import com.example.vehicleapi.model.VehicleStatusType;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleStatusMapperTest {

    private final VehicleStatusMapper mapper = Mappers.getMapper(VehicleStatusMapper.class);
    private final VehicleStatusTypeMapper typeMapper = Mappers.getMapper(VehicleStatusTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleStatusType type = VehicleStatusType.builder()
                .id(1)
                .code("IN_STOCK")
                .description("In stock")
                .build();

        VehicleStatus status = VehicleStatus.builder()
                .id(10)
                .vehicle(Vehicle.builder().id(5).build())
                .statusType(type)
                .statusDate(LocalDate.now())
                .notes("Checked in")
                .build();

        VehicleStatusDto dto = mapper.toDto(status);
        assertEquals("IN_STOCK", dto.getStatusType().getCode());

        VehicleStatus roundTrip = mapper.toEntity(dto);
        assertEquals("IN_STOCK", roundTrip.getStatusType().getCode());
    }
}