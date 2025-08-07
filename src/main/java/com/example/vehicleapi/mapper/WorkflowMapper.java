package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.model.Workflow;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowMapper {
    WorkflowMapper INSTANCE = Mappers.getMapper(WorkflowMapper.class);
    WorkflowDto toDto(Workflow entity);
    Workflow toEntity(WorkflowDto dto);
}
