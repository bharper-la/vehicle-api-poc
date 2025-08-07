package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.model.WorkflowStep;
import com.example.vehicleapi.mapper.WorkflowStepMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowStepMapperTest {
    private final WorkflowStepMapper mapper = Mappers.getMapper(WorkflowStepMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        WorkflowStep entity = new WorkflowStep();
        // Optionally set fields here
        WorkflowStepDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        WorkflowStep entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
