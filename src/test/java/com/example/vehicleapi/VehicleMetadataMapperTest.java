package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.model.VehicleMetadata;
import com.example.vehicleapi.mapper.VehicleMetadataMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleMetadataMapperTest {
    private final VehicleMetadataMapper mapper = Mappers.getMapper(VehicleMetadataMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        VehicleMetadata entity = new VehicleMetadata();
        // Optionally set fields here
        VehicleMetadataDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        VehicleMetadata entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
