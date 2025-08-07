package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.model.AuctionFilter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class AuctionFilterMapperImpl implements AuctionFilterMapper {

    @Override
    public AuctionFilterDto toDto(AuctionFilter entity) {
        if ( entity == null ) {
            return null;
        }

        AuctionFilterDto auctionFilterDto = new AuctionFilterDto();

        auctionFilterDto.setId( entity.getId() );
        auctionFilterDto.setFilterData( entity.getFilterData() );
        auctionFilterDto.setCreatedAt( entity.getCreatedAt() );

        return auctionFilterDto;
    }

    @Override
    public AuctionFilter toEntity(AuctionFilterDto dto) {
        if ( dto == null ) {
            return null;
        }

        AuctionFilter.AuctionFilterBuilder auctionFilter = AuctionFilter.builder();

        auctionFilter.id( dto.getId() );
        auctionFilter.filterData( dto.getFilterData() );
        auctionFilter.createdAt( dto.getCreatedAt() );

        return auctionFilter.build();
    }
}
