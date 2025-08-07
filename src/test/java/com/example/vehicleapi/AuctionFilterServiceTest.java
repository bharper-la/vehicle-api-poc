package com.example.vehicleapi;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import com.example.vehicleapi.repository.AuctionFilterRepository;
import com.example.vehicleapi.service.AuctionFilterService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuctionFilterServiceTest {
    @Mock
    private AuctionFilterRepository repository;
    @Mock
    private AuctionFilterMapper mapper;
    @InjectMocks
    private AuctionFilterService service;

    public AuctionFilterServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        AuctionFilter entity = new AuctionFilter();
        AuctionFilterDto dto = new AuctionFilterDto();
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1L));
    }
}
