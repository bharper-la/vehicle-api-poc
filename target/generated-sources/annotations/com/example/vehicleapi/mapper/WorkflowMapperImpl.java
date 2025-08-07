package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.model.Workflow;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowMapperImpl implements WorkflowMapper {

    @Override
    public WorkflowDto toDto(Workflow entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowDto workflowDto = new WorkflowDto();

        workflowDto.setId( entity.getId() );
        workflowDto.setName( entity.getName() );
        workflowDto.setCreatedAt( entity.getCreatedAt() );

        return workflowDto;
    }

    @Override
    public Workflow toEntity(WorkflowDto dto) {
        if ( dto == null ) {
            return null;
        }

        Workflow.WorkflowBuilder workflow = Workflow.builder();

        workflow.id( dto.getId() );
        workflow.name( dto.getName() );
        workflow.createdAt( dto.getCreatedAt() );

        return workflow.build();
    }
}
