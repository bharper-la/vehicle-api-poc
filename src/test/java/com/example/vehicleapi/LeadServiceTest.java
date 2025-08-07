package com.example.vehicleapi;

import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.model.Lead;
import com.example.vehicleapi.mapper.LeadMapper;
import com.example.vehicleapi.repository.LeadRepository;
import com.example.vehicleapi.service.LeadService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LeadServiceTest {
    @Mock
    private LeadRepository repository;
    @Mock
    private LeadMapper mapper;
    @InjectMocks
    private LeadService service;

    public LeadServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        Lead entity = new Lead();
        LeadDto dto = new LeadDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
