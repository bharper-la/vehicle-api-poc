package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.dto.UserDto;
import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.model.AuctionFilterType;
import com.example.vehicleapi.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AuctionFilterMapperTest {

    @Autowired
    private AuctionFilterMapper mapper;

    @Test
    void testEntityToDtoAndBack() {
        User user = User.builder().id(99).login("testuser").password("secret").build();
        AuctionFilterType type = AuctionFilterType.builder().id(5).filterType("PREFERRED_DEALERS").build();

        AuctionFilter entity = AuctionFilter.builder()
            .id(1)
            .user(user)
            .type(type)
            .filterData("{\"make\":\"Toyota\",\"model\":\"Camry\"}")
            .createdAt(LocalDateTime.of(2024, 1, 1, 12, 0))
            .build();

        AuctionFilterDto dto = mapper.toDto(entity);
        assertNotNull(dto);
        assertEquals("PREFERRED_DEALERS", dto.getType().getFilterType());
        assertEquals(99, dto.getUserId());

        AuctionFilter roundTrip = mapper.toEntity(dto);
        assertEquals("PREFERRED_DEALERS", roundTrip.getType().getFilterType());
        assertEquals(99, roundTrip.getUser().getId());
    }
}