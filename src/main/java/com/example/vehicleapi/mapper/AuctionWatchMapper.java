package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.model.AuctionWatch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuctionWatchMapper {
    AuctionWatchMapper INSTANCE = Mappers.getMapper(AuctionWatchMapper.class);
    AuctionWatchDto toDto(AuctionWatch entity);
    AuctionWatch toEntity(AuctionWatchDto dto);
}
