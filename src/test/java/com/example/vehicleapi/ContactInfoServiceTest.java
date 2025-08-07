package com.example.vehicleapi;

import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.model.ContactInfo;
import com.example.vehicleapi.mapper.ContactInfoMapper;
import com.example.vehicleapi.repository.ContactInfoRepository;
import com.example.vehicleapi.service.ContactInfoService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ContactInfoServiceTest {
    @Mock
    private ContactInfoRepository repository;
    @Mock
    private ContactInfoMapper mapper;
    @InjectMocks
    private ContactInfoService service;

    public ContactInfoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        ContactInfo entity = new ContactInfo();
        ContactInfoDto dto = new ContactInfoDto();
        when(repository.findById(1)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1));
    }
}
