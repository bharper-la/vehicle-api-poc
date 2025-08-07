package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.model.Lead;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-06T20:44:17-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Homebrew)"
)
@Component
public class LeadMapperImpl implements LeadMapper {

    @Override
    public LeadDto toDto(Lead entity) {
        if ( entity == null ) {
            return null;
        }

        LeadDto leadDto = new LeadDto();

        leadDto.setId( entity.getId() );
        leadDto.setDealership( entity.getDealership() );
        leadDto.setFirstName( entity.getFirstName() );
        leadDto.setLastName( entity.getLastName() );
        leadDto.setEmail( entity.getEmail() );
        leadDto.setPromoCode( entity.getPromoCode() );
        leadDto.setReferrer( entity.getReferrer() );
        leadDto.setStatus( entity.getStatus() );
        leadDto.setStatusDate( entity.getStatusDate() );
        leadDto.setExpirationDate( entity.getExpirationDate() );
        leadDto.setCreatedAt( entity.getCreatedAt() );
        leadDto.setUpdatedAt( entity.getUpdatedAt() );

        return leadDto;
    }

    @Override
    public Lead toEntity(LeadDto dto) {
        if ( dto == null ) {
            return null;
        }

        Lead.LeadBuilder lead = Lead.builder();

        lead.id( dto.getId() );
        lead.dealership( dto.getDealership() );
        lead.firstName( dto.getFirstName() );
        lead.lastName( dto.getLastName() );
        lead.email( dto.getEmail() );
        lead.promoCode( dto.getPromoCode() );
        lead.referrer( dto.getReferrer() );
        lead.status( dto.getStatus() );
        lead.statusDate( dto.getStatusDate() );
        lead.expirationDate( dto.getExpirationDate() );
        lead.createdAt( dto.getCreatedAt() );
        lead.updatedAt( dto.getUpdatedAt() );

        return lead.build();
    }
}
