package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.model.WorkflowStepType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowStepTypeMapperImpl implements WorkflowStepTypeMapper {

    @Override
    public WorkflowStepTypeDto toDto(WorkflowStepType entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowStepTypeDto workflowStepTypeDto = new WorkflowStepTypeDto();

        workflowStepTypeDto.setId( entity.getId() );
        workflowStepTypeDto.setName( entity.getName() );
        workflowStepTypeDto.setDescription( entity.getDescription() );

        return workflowStepTypeDto;
    }

    @Override
    public WorkflowStepType toEntity(WorkflowStepTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkflowStepType.WorkflowStepTypeBuilder workflowStepType = WorkflowStepType.builder();

        workflowStepType.id( dto.getId() );
        workflowStepType.name( dto.getName() );
        workflowStepType.description( dto.getDescription() );

        return workflowStepType.build();
    }
}
