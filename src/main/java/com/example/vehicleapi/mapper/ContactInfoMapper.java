package com.example.vehicleapi.mapper;

import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.model.ContactInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContactInfoMapper {
    ContactInfoMapper INSTANCE = Mappers.getMapper(ContactInfoMapper.class);
    ContactInfoDto toDto(ContactInfo entity);
    ContactInfo toEntity(ContactInfoDto dto);
}
