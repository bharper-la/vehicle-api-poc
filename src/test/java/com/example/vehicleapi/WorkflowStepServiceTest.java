package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.model.WorkflowStep;
import com.example.vehicleapi.mapper.WorkflowStepMapper;
import com.example.vehicleapi.repository.WorkflowStepRepository;
import com.example.vehicleapi.service.WorkflowStepService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowStepServiceTest {
    @Mock
    private WorkflowStepRepository repository;
    @Mock
    private WorkflowStepMapper mapper;
    @InjectMocks
    private WorkflowStepService service;

    public WorkflowStepServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        WorkflowStep entity = new WorkflowStep();
        WorkflowStepDto dto = new WorkflowStepDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
