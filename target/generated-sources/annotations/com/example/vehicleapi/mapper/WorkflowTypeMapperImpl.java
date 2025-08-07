package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.model.WorkflowType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowTypeMapperImpl implements WorkflowTypeMapper {

    @Override
    public WorkflowTypeDto toDto(WorkflowType entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowTypeDto workflowTypeDto = new WorkflowTypeDto();

        workflowTypeDto.setId( entity.getId() );
        workflowTypeDto.setName( entity.getName() );
        workflowTypeDto.setDescription( entity.getDescription() );

        return workflowTypeDto;
    }

    @Override
    public WorkflowType toEntity(WorkflowTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkflowType.WorkflowTypeBuilder workflowType = WorkflowType.builder();

        workflowType.id( dto.getId() );
        workflowType.name( dto.getName() );
        workflowType.description( dto.getDescription() );

        return workflowType.build();
    }
}
