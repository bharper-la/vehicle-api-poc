package com.example.vehicleapi;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.model.AuctionWatch;
import com.example.vehicleapi.mapper.AuctionWatchMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.*;

public class AuctionWatchMapperTest {
    private final AuctionWatchMapper mapper = Mappers.getMapper(AuctionWatchMapper.class);

    @Test
    void testEntityToDtoAndBack() {
        AuctionWatch entity = new AuctionWatch();
        // Optionally set fields here
        AuctionWatchDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        AuctionWatch entity2 = mapper.toEntity(dto);
        assertNotNull(entity2);
    }
}
