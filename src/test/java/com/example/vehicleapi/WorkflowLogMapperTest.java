package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.model.WorkflowLog;
import com.example.vehicleapi.mapper.WorkflowLogMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class WorkflowLogMapperTest {
    private final WorkflowLogMapper mapper = Mappers.getMapper(WorkflowLogMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        WorkflowLog entity = new WorkflowLog();
        // Optionally set fields here
        WorkflowLogDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        WorkflowLog entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
