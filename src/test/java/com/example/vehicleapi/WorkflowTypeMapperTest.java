package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.model.WorkflowType;
import com.example.vehicleapi.mapper.WorkflowTypeMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowTypeMapperTest {
    private final WorkflowTypeMapper mapper = Mappers.getMapper(WorkflowTypeMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        WorkflowType entity = new WorkflowType();
        // Optionally set fields here
        WorkflowTypeDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        WorkflowType entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
