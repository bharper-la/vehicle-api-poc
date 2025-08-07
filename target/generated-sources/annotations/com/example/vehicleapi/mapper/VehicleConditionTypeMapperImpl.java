package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.model.VehicleConditionType;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleConditionTypeMapperImpl implements VehicleConditionTypeMapper {

    @Override
    public VehicleConditionTypeDto toDto(VehicleConditionType entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleConditionTypeDto vehicleConditionTypeDto = new VehicleConditionTypeDto();

        vehicleConditionTypeDto.setId( entity.getId() );
        vehicleConditionTypeDto.setCode( entity.getCode() );
        vehicleConditionTypeDto.setDescription( entity.getDescription() );

        return vehicleConditionTypeDto;
    }

    @Override
    public VehicleConditionType toEntity(VehicleConditionTypeDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleConditionType.VehicleConditionTypeBuilder vehicleConditionType = VehicleConditionType.builder();

        vehicleConditionType.id( dto.getId() );
        vehicleConditionType.code( dto.getCode() );
        vehicleConditionType.description( dto.getDescription() );

        return vehicleConditionType.build();
    }
}
