package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.model.VehicleMetadata;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleMetadataMapperImpl implements VehicleMetadataMapper {

    @Override
    public VehicleMetadataDto toDto(VehicleMetadata entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleMetadataDto vehicleMetadataDto = new VehicleMetadataDto();

        vehicleMetadataDto.setId( entity.getId() );
        vehicleMetadataDto.setType( entity.getType() );
        vehicleMetadataDto.setData( entity.getData() );
        vehicleMetadataDto.setCreatedAt( entity.getCreatedAt() );

        return vehicleMetadataDto;
    }

    @Override
    public VehicleMetadata toEntity(VehicleMetadataDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleMetadata.VehicleMetadataBuilder vehicleMetadata = VehicleMetadata.builder();

        vehicleMetadata.id( dto.getId() );
        vehicleMetadata.type( dto.getType() );
        vehicleMetadata.data( dto.getData() );
        vehicleMetadata.createdAt( dto.getCreatedAt() );

        return vehicleMetadata.build();
    }
}
