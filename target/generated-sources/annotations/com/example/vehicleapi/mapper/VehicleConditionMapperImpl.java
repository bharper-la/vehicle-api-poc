package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.model.VehicleCondition;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class VehicleConditionMapperImpl implements VehicleConditionMapper {

    @Override
    public VehicleConditionDto toDto(VehicleCondition entity) {
        if ( entity == null ) {
            return null;
        }

        VehicleConditionDto vehicleConditionDto = new VehicleConditionDto();

        vehicleConditionDto.setId( entity.getId() );
        vehicleConditionDto.setConditionDate( entity.getConditionDate() );
        vehicleConditionDto.setComments( entity.getComments() );

        return vehicleConditionDto;
    }

    @Override
    public VehicleCondition toEntity(VehicleConditionDto dto) {
        if ( dto == null ) {
            return null;
        }

        VehicleCondition.VehicleConditionBuilder vehicleCondition = VehicleCondition.builder();

        vehicleCondition.id( dto.getId() );
        vehicleCondition.conditionDate( dto.getConditionDate() );
        vehicleCondition.comments( dto.getComments() );

        return vehicleCondition.build();
    }
}
