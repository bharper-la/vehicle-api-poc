package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.model.VehicleMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleMetadataMapper {
    VehicleMetadataMapper INSTANCE = Mappers.getMapper(VehicleMetadataMapper.class);
    VehicleMetadataDto toDto(VehicleMetadata entity);
    VehicleMetadata toEntity(VehicleMetadataDto dto);
}
