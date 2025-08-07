package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.model.ContactInfo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class ContactInfoMapperImpl implements ContactInfoMapper {

    @Override
    public ContactInfoDto toDto(ContactInfo entity) {
        if ( entity == null ) {
            return null;
        }

        ContactInfoDto contactInfoDto = new ContactInfoDto();

        contactInfoDto.setId( entity.getId() );
        contactInfoDto.setEmail( entity.getEmail() );
        contactInfoDto.setPhoneAreaCode( entity.getPhoneAreaCode() );
        contactInfoDto.setPhoneExchangeNumber( entity.getPhoneExchangeNumber() );
        contactInfoDto.setPhoneUnitNumber( entity.getPhoneUnitNumber() );
        contactInfoDto.setPhoneExtension( entity.getPhoneExtension() );

        return contactInfoDto;
    }

    @Override
    public ContactInfo toEntity(ContactInfoDto dto) {
        if ( dto == null ) {
            return null;
        }

        ContactInfo.ContactInfoBuilder contactInfo = ContactInfo.builder();

        contactInfo.id( dto.getId() );
        contactInfo.email( dto.getEmail() );
        contactInfo.phoneAreaCode( dto.getPhoneAreaCode() );
        contactInfo.phoneExchangeNumber( dto.getPhoneExchangeNumber() );
        contactInfo.phoneUnitNumber( dto.getPhoneUnitNumber() );
        contactInfo.phoneExtension( dto.getPhoneExtension() );

        return contactInfo.build();
    }
}
