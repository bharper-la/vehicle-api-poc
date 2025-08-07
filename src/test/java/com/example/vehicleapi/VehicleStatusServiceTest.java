package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.model.VehicleStatus;
import com.example.vehicleapi.mapper.VehicleStatusMapper;
import com.example.vehicleapi.repository.VehicleStatusRepository;
import com.example.vehicleapi.service.VehicleStatusService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleStatusServiceTest {
    @Mock
    private VehicleStatusRepository repository;
    @Mock
    private VehicleStatusMapper mapper;
    @InjectMocks
    private VehicleStatusService service;

    public VehicleStatusServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        VehicleStatus entity = new VehicleStatus();
        VehicleStatusDto dto = new VehicleStatusDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
