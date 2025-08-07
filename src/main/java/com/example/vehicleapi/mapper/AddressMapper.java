package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
    AddressDto toDto(Address entity);
    Address toEntity(AddressDto dto);
}
