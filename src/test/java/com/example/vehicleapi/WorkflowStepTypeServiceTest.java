package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.model.WorkflowStepType;
import com.example.vehicleapi.mapper.WorkflowStepTypeMapper;
import com.example.vehicleapi.repository.WorkflowStepTypeRepository;
import com.example.vehicleapi.service.WorkflowStepTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowStepTypeServiceTest {
    @Mock
    private WorkflowStepTypeRepository repository;
    @Mock
    private WorkflowStepTypeMapper mapper;
    @InjectMocks
    private WorkflowStepTypeService service;

    public WorkflowStepTypeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.findAll().size());
    }

    @Test
    void testGetById() {
        WorkflowStepType entity = new WorkflowStepType();
        WorkflowStepTypeDto dto = new WorkflowStepTypeDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.findById(1));
    }
}
