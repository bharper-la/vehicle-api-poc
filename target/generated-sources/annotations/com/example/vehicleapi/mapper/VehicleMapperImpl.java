package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.model.Vehicle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleDto toDto(Vehicle entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setId( entity.getId() );
        vehicleDto.setVin( entity.getVin() );
        vehicleDto.setMake( entity.getMake() );
        vehicleDto.setModel( entity.getModel() );
        vehicleDto.setYear( entity.getYear() );
        vehicleDto.setCreatedAt( entity.getCreatedAt() );
        vehicleDto.setUpdatedAt( entity.getUpdatedAt() );

        return vehicleDto;
    }

    @Override
    public Vehicle toEntity(VehicleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Vehicle.VehicleBuilder vehicle = Vehicle.builder();

        vehicle.id( dto.getId() );
        vehicle.vin( dto.getVin() );
        vehicle.make( dto.getMake() );
        vehicle.model( dto.getModel() );
        vehicle.year( dto.getYear() );
        vehicle.createdAt( dto.getCreatedAt() );
        vehicle.updatedAt( dto.getUpdatedAt() );

        return vehicle.build();
    }
}
