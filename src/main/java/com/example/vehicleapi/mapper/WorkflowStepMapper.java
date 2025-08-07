package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.model.WorkflowStep;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowStepMapper {
    WorkflowStepMapper INSTANCE = Mappers.getMapper(WorkflowStepMapper.class);
    WorkflowStepDto toDto(WorkflowStep entity);
    WorkflowStep toEntity(WorkflowStepDto dto);
}
