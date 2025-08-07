package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.model.WorkflowStepType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowStepTypeMapper {
    WorkflowStepTypeMapper INSTANCE = Mappers.getMapper(WorkflowStepTypeMapper.class);
    WorkflowStepTypeDto toDto(WorkflowStepType entity);
    WorkflowStepType toEntity(WorkflowStepTypeDto dto);
}
