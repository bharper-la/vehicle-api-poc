package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.model.WorkflowQueue;
import com.example.vehicleapi.mapper.WorkflowQueueMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowQueueMapperTest {
    private final WorkflowQueueMapper mapper = Mappers.getMapper(WorkflowQueueMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        WorkflowQueue entity = new WorkflowQueue();
        // Optionally set fields here
        WorkflowQueueDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        WorkflowQueue entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
