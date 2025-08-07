package com.example.vehicleapi;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.model.Address;
import com.example.vehicleapi.mapper.AddressMapper;
import com.example.vehicleapi.repository.AddressRepository;
import com.example.vehicleapi.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressServiceTest {
    @Mock
    private AddressRepository repository;
    @Mock
    private AddressMapper mapper;
    @InjectMocks
    private AddressService service;

    public AddressServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        Address entity = new Address();
        AddressDto dto = new AddressDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
