package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.model.Address;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public AddressDto toDto(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( entity.getId() );
        addressDto.setLine1( entity.getLine1() );
        addressDto.setLine2( entity.getLine2() );
        addressDto.setCity( entity.getCity() );
        addressDto.setState( entity.getState() );
        addressDto.setPostalCode( entity.getPostalCode() );

        return addressDto;
    }

    @Override
    public Address toEntity(AddressDto dto) {
        if ( dto == null ) {
            return null;
        }

        Address.AddressBuilder address = Address.builder();

        address.id( dto.getId() );
        address.line1( dto.getLine1() );
        address.line2( dto.getLine2() );
        address.city( dto.getCity() );
        address.state( dto.getState() );
        address.postalCode( dto.getPostalCode() );

        return address.build();
    }
}
