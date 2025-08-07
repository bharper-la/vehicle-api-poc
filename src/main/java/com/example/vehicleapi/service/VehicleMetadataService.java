package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.mapper.VehicleMetadataMapper;
import com.example.vehicleapi.repository.VehicleMetadataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleMetadataService {
    private final VehicleMetadataRepository repository;
    private final VehicleMetadataMapper mapper;

    public List<VehicleMetadataDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleMetadataDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleMetadataDto create(VehicleMetadataDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleMetadataDto update(Long id, VehicleMetadataDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
