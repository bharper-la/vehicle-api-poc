package com.example.vehicleapi;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class AuctionFilterMapperTest {
    private final AuctionFilterMapper mapper = Mappers.getMapper(AuctionFilterMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        AuctionFilter entity = new AuctionFilter();
        // Optionally set fields here
        AuctionFilterDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        AuctionFilter entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
