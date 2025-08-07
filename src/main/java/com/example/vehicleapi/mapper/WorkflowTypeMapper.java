package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.model.WorkflowType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowTypeMapper {
    WorkflowTypeMapper INSTANCE = Mappers.getMapper(WorkflowTypeMapper.class);
    WorkflowTypeDto toDto(WorkflowType entity);
    WorkflowType toEntity(WorkflowTypeDto dto);
}
