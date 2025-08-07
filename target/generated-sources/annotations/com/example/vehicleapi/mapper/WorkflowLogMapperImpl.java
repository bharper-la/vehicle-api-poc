package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.model.WorkflowLog;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class WorkflowLogMapperImpl implements WorkflowLogMapper {

    @Override
    public WorkflowLogDto toDto(WorkflowLog entity) {
        if ( entity == null ) {
            return null;
        }

        WorkflowLogDto workflowLogDto = new WorkflowLogDto();

        workflowLogDto.setId( entity.getId() );
        workflowLogDto.setMessage( entity.getMessage() );
        workflowLogDto.setCreatedAt( entity.getCreatedAt() );

        return workflowLogDto;
    }

    @Override
    public WorkflowLog toEntity(WorkflowLogDto dto) {
        if ( dto == null ) {
            return null;
        }

        WorkflowLog.WorkflowLogBuilder workflowLog = WorkflowLog.builder();

        workflowLog.id( dto.getId() );
        workflowLog.message( dto.getMessage() );
        workflowLog.createdAt( dto.getCreatedAt() );

        return workflowLog.build();
    }
}
