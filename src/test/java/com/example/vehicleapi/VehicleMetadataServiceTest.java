package com.example.vehicleapi;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.model.VehicleMetadata;
import com.example.vehicleapi.mapper.VehicleMetadataMapper;
import com.example.vehicleapi.repository.VehicleMetadataRepository;
import com.example.vehicleapi.service.VehicleMetadataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleMetadataServiceTest {
    @Mock
    private VehicleMetadataRepository repository;
    @Mock
    private VehicleMetadataMapper mapper;
    @InjectMocks
    private VehicleMetadataService service;

    public VehicleMetadataServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        VehicleMetadata entity = new VehicleMetadata();
        VehicleMetadataDto dto = new VehicleMetadataDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
