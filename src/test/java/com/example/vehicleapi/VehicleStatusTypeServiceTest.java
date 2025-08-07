package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.model.VehicleStatusType;
import com.example.vehicleapi.mapper.VehicleStatusTypeMapper;
import com.example.vehicleapi.repository.VehicleStatusTypeRepository;
import com.example.vehicleapi.service.VehicleStatusTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleStatusTypeServiceTest {
    @Mock
    private VehicleStatusTypeRepository repository;
    @Mock
    private VehicleStatusTypeMapper mapper;
    @InjectMocks
    private VehicleStatusTypeService service;

    public VehicleStatusTypeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        VehicleStatusType entity = new VehicleStatusType();
        VehicleStatusTypeDto dto = new VehicleStatusTypeDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
