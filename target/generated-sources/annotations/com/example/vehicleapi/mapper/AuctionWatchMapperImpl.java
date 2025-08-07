package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.model.AuctionWatch;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class AuctionWatchMapperImpl implements AuctionWatchMapper {

    @Override
    public AuctionWatchDto toDto(AuctionWatch entity) {
        if ( entity == null ) {
            return null;
        }

        AuctionWatchDto auctionWatchDto = new AuctionWatchDto();

        auctionWatchDto.setId( entity.getId() );
        auctionWatchDto.setWatchData( entity.getWatchData() );
        auctionWatchDto.setCreatedAt( entity.getCreatedAt() );

        return auctionWatchDto;
    }

    @Override
    public AuctionWatch toEntity(AuctionWatchDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuctionWatch.AuctionWatchBuilder auctionWatch = AuctionWatch.builder();

        auctionWatch.id( dto.getId() );
        auctionWatch.watchData( dto.getWatchData() );
        auctionWatch.createdAt( dto.getCreatedAt() );

        return auctionWatch.build();
    }
}
