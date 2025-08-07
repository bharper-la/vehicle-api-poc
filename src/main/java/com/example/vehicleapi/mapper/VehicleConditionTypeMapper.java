package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.model.VehicleConditionType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleConditionTypeMapper {
    VehicleConditionTypeMapper INSTANCE = Mappers.getMapper(VehicleConditionTypeMapper.class);
    VehicleConditionTypeDto toDto(VehicleConditionType entity);
    VehicleConditionType toEntity(VehicleConditionTypeDto dto);
}
