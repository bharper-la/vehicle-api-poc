package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.model.WorkflowQueue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WorkflowQueueMapper {
    WorkflowQueueMapper INSTANCE = Mappers.getMapper(WorkflowQueueMapper.class);
    WorkflowQueueDto toDto(WorkflowQueue entity);
    WorkflowQueue toEntity(WorkflowQueueDto dto);
}
