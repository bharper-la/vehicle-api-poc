package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.model.VehicleCondition;
import com.example.vehicleapi.mapper.VehicleConditionMapper;
import com.example.vehicleapi.repository.VehicleConditionRepository;
import com.example.vehicleapi.service.VehicleConditionService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleConditionServiceTest {
    @Mock
    private VehicleConditionRepository repository;
    @Mock
    private VehicleConditionMapper mapper;
    @InjectMocks
    private VehicleConditionService service;

    public VehicleConditionServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        VehicleCondition entity = new VehicleCondition();
        VehicleConditionDto dto = new VehicleConditionDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
