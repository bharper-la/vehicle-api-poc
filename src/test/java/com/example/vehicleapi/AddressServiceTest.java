package com.example.vehicleapi;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import com.example.vehicleapi.mapper.AuctionFilterTypeMapper;
import com.example.vehicleapi.model.Address;
import com.example.vehicleapi.mapper.AddressMapper;
import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.model.AuctionFilterType;
import com.example.vehicleapi.model.User;
import com.example.vehicleapi.repository.AddressRepository;
import com.example.vehicleapi.service.AddressService;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
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

    public static class AuctionFilterMapperTest {

        private final AuctionFilterMapper mapper = Mappers.getMapper(AuctionFilterMapper.class);
        private final AuctionFilterTypeMapper typeMapper = Mappers.getMapper(AuctionFilterTypeMapper.class);

        @Test
        void testEntityToDtoAndBack() {
            AuctionFilterType type = AuctionFilterType.builder()
                    .id(1)
                    .filterType("deal_type")
                    .createdAt(LocalDateTime.now())
                    .build();

            User user = User.builder()
                    .id(2)
                    .login("test")
                    .password("secret")
                    .build();

            AuctionFilter entity = AuctionFilter.builder()
                    .id(10)
                    .type(type)
                    .user(user)
                    .filterData("{\"make\":\"Honda\"}")
                    .createdAt(LocalDateTime.now())
                    .build();

            AuctionFilterDto dto = mapper.toDto(entity);
            assertEquals("deal_type", dto.getType().getFilterType());
            assertEquals(2, dto.getUserId());

            AuctionFilter roundTrip = mapper.toEntity(dto);
            assertEquals("deal_type", roundTrip.getType().getFilterType());
            assertEquals(2, roundTrip.getUser().getId());
        }
    }
}
