package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.model.Lead;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LeadMapper {
    LeadMapper INSTANCE = Mappers.getMapper(LeadMapper.class);
    LeadDto toDto(Lead entity);
    Lead toEntity(LeadDto dto);
}
