package com.example.vehicleapi.mapper;

import com.example.vehicleapi.model.WorkflowLog;
import com.example.vehicleapi.dto.WorkflowLogDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowLogMapper {
    WorkflowLogMapper INSTANCE = Mappers.getMapper(WorkflowLogMapper.class);
    WorkflowLogDto toDto(WorkflowLog entity);
    WorkflowLog toEntity(WorkflowLogDto dto);
}
