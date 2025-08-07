package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.model.WorkflowType;
import com.example.vehicleapi.mapper.WorkflowTypeMapper;
import com.example.vehicleapi.repository.WorkflowTypeRepository;
import com.example.vehicleapi.service.WorkflowTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowTypeServiceTest {
    @Mock
    private WorkflowTypeRepository repository;
    @Mock
    private WorkflowTypeMapper mapper;
    @InjectMocks
    private WorkflowTypeService service;

    public WorkflowTypeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        WorkflowType entity = new WorkflowType();
        WorkflowTypeDto dto = new WorkflowTypeDto();
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1L));
    }
}
