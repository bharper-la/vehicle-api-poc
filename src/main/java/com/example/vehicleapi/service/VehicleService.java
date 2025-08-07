package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.mapper.VehicleMapper;
import com.example.vehicleapi.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {
    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    public List<VehicleDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleDto create(VehicleDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleDto update(Integer id, VehicleDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
