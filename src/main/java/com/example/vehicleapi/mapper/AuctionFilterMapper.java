package com.example.vehicleapi.mapper;

import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.dto.AuctionFilterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AuctionFilterTypeMapper.class})
public interface AuctionFilterMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "type", source = "type")
    AuctionFilterDto toDto(AuctionFilter entity);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "type", source = "type")
    AuctionFilter toEntity(AuctionFilterDto dto);
}
