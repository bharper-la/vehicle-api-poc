package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.mapper.VehicleStatusMapper;
import com.example.vehicleapi.repository.VehicleStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleStatusService {
    private final VehicleStatusRepository repository;
    private final VehicleStatusMapper mapper;

    public List<VehicleStatusDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleStatusDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleStatusDto create(VehicleStatusDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleStatusDto update(Long id, VehicleStatusDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
