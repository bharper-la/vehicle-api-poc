package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.mapper.VehicleStatusTypeMapper;
import com.example.vehicleapi.repository.VehicleStatusTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleStatusTypeService {
    private final VehicleStatusTypeRepository repository;
    private final VehicleStatusTypeMapper mapper;

    public List<VehicleStatusTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleStatusTypeDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleStatusTypeDto create(VehicleStatusTypeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleStatusTypeDto update(Integer id, VehicleStatusTypeDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
