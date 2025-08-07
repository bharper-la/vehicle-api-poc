package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.model.AuctionFilter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuctionFilterMapper {
    AuctionFilterMapper INSTANCE = Mappers.getMapper(AuctionFilterMapper.class);
    AuctionFilterDto toDto(AuctionFilter entity);
    AuctionFilter toEntity(AuctionFilterDto dto);
}
