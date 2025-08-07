package com.example.vehicleapi;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.model.AuctionWatch;
import com.example.vehicleapi.mapper.AuctionWatchMapper;
import com.example.vehicleapi.repository.AuctionWatchRepository;
import com.example.vehicleapi.service.AuctionWatchService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuctionWatchServiceTest {
    @Mock
    private AuctionWatchRepository repository;
    @Mock
    private AuctionWatchMapper mapper;
    @InjectMocks
    private AuctionWatchService service;

    public AuctionWatchServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertEquals(0, service.getAll().size());
    }

    @Test
    void testGetById() {
        AuctionWatch entity = new AuctionWatch();
        AuctionWatchDto dto = new AuctionWatchDto();
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);
        assertEquals(dto, service.getById(1L));
    }
}
