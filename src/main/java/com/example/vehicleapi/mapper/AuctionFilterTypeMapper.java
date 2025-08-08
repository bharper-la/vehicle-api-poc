package com.example.vehicleapi.mapper;

import com.example.vehicleapi.model.AuctionFilterType;
import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuctionFilterTypeMapper {
    AuctionFilterTypeDto toDto(AuctionFilterType entity);
    AuctionFilterType toEntity(AuctionFilterTypeDto dto);
}
