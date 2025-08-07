package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.model.WorkflowStep;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowStepMapperImpl implements WorkflowStepMapper {

    @Override
    public WorkflowStepDto toDto(WorkflowStep entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowStepDto workflowStepDto = new WorkflowStepDto();

        workflowStepDto.setId( entity.getId() );
        workflowStepDto.setDescription( entity.getDescription() );
        workflowStepDto.setCreatedAt( entity.getCreatedAt() );

        return workflowStepDto;
    }

    @Override
    public WorkflowStep toEntity(WorkflowStepDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkflowStep.WorkflowStepBuilder workflowStep = WorkflowStep.builder();

        workflowStep.id( dto.getId() );
        workflowStep.description( dto.getDescription() );
        workflowStep.createdAt( dto.getCreatedAt() );

        return workflowStep.build();
    }
}
