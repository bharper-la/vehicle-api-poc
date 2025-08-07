package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.model.VehicleStatusType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VehicleStatusTypeMapper {
    VehicleStatusTypeMapper INSTANCE = Mappers.getMapper(VehicleStatusTypeMapper.class);
    VehicleStatusTypeDto toDto(VehicleStatusType entity);
    VehicleStatusType toEntity(VehicleStatusTypeDto dto);
}
