package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.model.Workflow;
import com.example.vehicleapi.mapper.WorkflowMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowMapperTest {
    private final WorkflowMapper mapper = Mappers.getMapper(WorkflowMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        Workflow entity = new Workflow();
        // Optionally set fields here
        WorkflowDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        Workflow entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
