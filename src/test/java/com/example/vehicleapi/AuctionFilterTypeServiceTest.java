
package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.mapper.AuctionFilterTypeMapper;
import com.example.vehicleapi.model.AuctionFilterType;
import com.example.vehicleapi.repository.AuctionFilterTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AuctionFilterTypeServiceTest {

    private AuctionFilterTypeService service;
    private AuctionFilterTypeRepository repository;
    private AuctionFilterTypeMapper mapper;

    @BeforeEach
    void setup() {
        repository = mock(AuctionFilterTypeRepository.class);
        mapper = mock(AuctionFilterTypeMapper.class);
        service = new AuctionFilterTypeService(repository, mapper);
    }

    @Test
    public void testFindAll() {
        when(repository.findAll()).thenReturn(List.of());
        when(mapper.toDto(any())).thenReturn(new AuctionFilterTypeDto());
        List<AuctionFilterTypeDto> result = service.findAll();
        assertNotNull(result);
    }
}
