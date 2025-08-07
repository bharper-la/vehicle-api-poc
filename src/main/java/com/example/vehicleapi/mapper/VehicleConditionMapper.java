package com.example.vehicleapi.mapper;

import com.example.vehicleapi.model.VehicleCondition;
import com.example.vehicleapi.dto.VehicleConditionDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleConditionMapper {
    VehicleConditionMapper INSTANCE = Mappers.getMapper(VehicleConditionMapper.class);
    VehicleConditionDto toDto(VehicleCondition entity);
    VehicleCondition toEntity(VehicleConditionDto dto);
}
