package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.model.VehicleStatus;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleStatusMapperImpl implements VehicleStatusMapper {

    @Override
    public VehicleStatusDto toDto(VehicleStatus entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleStatusDto vehicleStatusDto = new VehicleStatusDto();

        vehicleStatusDto.setId( entity.getId() );
        vehicleStatusDto.setStatusDate( entity.getStatusDate() );
        vehicleStatusDto.setNotes( entity.getNotes() );

        return vehicleStatusDto;
    }

    @Override
    public VehicleStatus toEntity(VehicleStatusDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleStatus.VehicleStatusBuilder vehicleStatus = VehicleStatus.builder();

        vehicleStatus.id( dto.getId() );
        vehicleStatus.statusDate( dto.getStatusDate() );
        vehicleStatus.notes( dto.getNotes() );

        return vehicleStatus.build();
    }
}
