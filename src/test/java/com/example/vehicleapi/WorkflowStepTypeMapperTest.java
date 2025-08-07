package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.model.WorkflowStepType;
import com.example.vehicleapi.mapper.WorkflowStepTypeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowStepTypeMapperTest {
    private final WorkflowStepTypeMapper mapper = Mappers.getMapper(WorkflowStepTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        WorkflowStepType entity = new WorkflowStepType();
        // Optionally set fields here
        WorkflowStepTypeDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        WorkflowStepType entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
