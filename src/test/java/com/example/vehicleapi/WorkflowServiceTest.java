package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.model.Workflow;
import com.example.vehicleapi.mapper.WorkflowMapper;
import com.example.vehicleapi.repository.WorkflowRepository;
import com.example.vehicleapi.service.WorkflowService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowServiceTest {
    @Mock
    private WorkflowRepository repository;
    @Mock
    private WorkflowMapper mapper;
    @InjectMocks
    private WorkflowService service;

    public WorkflowServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        Workflow entity = new Workflow();
        WorkflowDto dto = new WorkflowDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
