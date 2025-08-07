package com.example.vehicleapi;

import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.model.WorkflowLog;
import com.example.vehicleapi.mapper.WorkflowLogMapper;
import com.example.vehicleapi.repository.WorkflowLogRepository;
import com.example.vehicleapi.service.WorkflowLogService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class WorkflowLogServiceTest {
    @Mock
    private WorkflowLogRepository repository;
    @Mock
    private WorkflowLogMapper mapper;
    @InjectMocks
    private WorkflowLogService service;

    public WorkflowLogServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        WorkflowLog entity = new WorkflowLog();
        WorkflowLogDto dto = new WorkflowLogDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
