package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.model.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);
    VehicleDto toDto(Vehicle entity);
    Vehicle toEntity(VehicleDto dto);
}
