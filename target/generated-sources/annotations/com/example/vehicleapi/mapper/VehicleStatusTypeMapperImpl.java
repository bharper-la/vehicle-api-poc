package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.model.VehicleStatusType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleStatusTypeMapperImpl implements VehicleStatusTypeMapper {

    @Override
    public VehicleStatusTypeDto toDto(VehicleStatusType entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleStatusTypeDto vehicleStatusTypeDto = new VehicleStatusTypeDto();

        vehicleStatusTypeDto.setId( entity.getId() );
        vehicleStatusTypeDto.setCode( entity.getCode() );
        vehicleStatusTypeDto.setDescription( entity.getDescription() );

        return vehicleStatusTypeDto;
    }

    @Override
    public VehicleStatusType toEntity(VehicleStatusTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleStatusType.VehicleStatusTypeBuilder vehicleStatusType = VehicleStatusType.builder();

        vehicleStatusType.id( dto.getId() );
        vehicleStatusType.code( dto.getCode() );
        vehicleStatusType.description( dto.getDescription() );

        return vehicleStatusType.build();
    }
}
