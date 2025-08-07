package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.model.Vehicle;
import com.example.vehicleapi.mapper.VehicleMapper;
import com.example.vehicleapi.repository.VehicleRepository;
import com.example.vehicleapi.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {
    @Mock
    private VehicleRepository repository;
    @Mock
    private VehicleMapper mapper;
    @InjectMocks
    private VehicleService service;

    public VehicleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        Vehicle entity = new Vehicle();
        VehicleDto dto = new VehicleDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
