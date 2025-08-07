package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.model.WorkflowQueue;
import com.example.vehicleapi.mapper.WorkflowQueueMapper;
import com.example.vehicleapi.repository.WorkflowQueueRepository;
import com.example.vehicleapi.service.WorkflowQueueService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowQueueServiceTest {
    @Mock
    private WorkflowQueueRepository repository;
    @Mock
    private WorkflowQueueMapper mapper;
    @InjectMocks
    private WorkflowQueueService service;

    public WorkflowQueueServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        WorkflowQueue entity = new WorkflowQueue();
        WorkflowQueueDto dto = new WorkflowQueueDto();
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1L));
    }
}
