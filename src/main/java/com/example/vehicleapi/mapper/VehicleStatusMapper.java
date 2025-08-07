package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.model.VehicleStatus;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleStatusMapper {
    VehicleStatusMapper INSTANCE = Mappers.getMapper(VehicleStatusMapper.class);
    VehicleStatusDto toDto(VehicleStatus entity);
    VehicleStatus toEntity(VehicleStatusDto dto);
}
