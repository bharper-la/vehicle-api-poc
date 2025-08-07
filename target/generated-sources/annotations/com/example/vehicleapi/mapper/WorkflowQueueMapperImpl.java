package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.model.WorkflowQueue;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowQueueMapperImpl implements WorkflowQueueMapper {

    @Override
    public WorkflowQueueDto toDto(WorkflowQueue entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowQueueDto workflowQueueDto = new WorkflowQueueDto();

        workflowQueueDto.setId( entity.getId() );
        workflowQueueDto.setStatus( entity.getStatus() );
        workflowQueueDto.setCreatedAt( entity.getCreatedAt() );

        return workflowQueueDto;
    }

    @Override
    public WorkflowQueue toEntity(WorkflowQueueDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkflowQueue.WorkflowQueueBuilder workflowQueue = WorkflowQueue.builder();

        workflowQueue.id( dto.getId() );
        workflowQueue.status( dto.getStatus() );
        workflowQueue.createdAt( dto.getCreatedAt() );

        return workflowQueue.build();
    }
}
