package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.model.VehicleConditionType;
import com.example.vehicleapi.mapper.VehicleConditionTypeMapper;
import com.example.vehicleapi.repository.VehicleConditionTypeRepository;
import com.example.vehicleapi.service.VehicleConditionTypeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleConditionTypeServiceTest {
    @Mock
    private VehicleConditionTypeRepository repository;
    @Mock
    private VehicleConditionTypeMapper mapper;
    @InjectMocks
    private VehicleConditionTypeService service;

    public VehicleConditionTypeServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        VehicleConditionType entity = new VehicleConditionType();
        VehicleConditionTypeDto dto = new VehicleConditionTypeDto();
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1L));
    }
}
