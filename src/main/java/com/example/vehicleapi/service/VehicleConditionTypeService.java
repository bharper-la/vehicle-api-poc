package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.mapper.VehicleConditionTypeMapper;
import com.example.vehicleapi.repository.VehicleConditionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleConditionTypeService {
    private final VehicleConditionTypeRepository repository;
    private final VehicleConditionTypeMapper mapper;

    public List<VehicleConditionTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleConditionTypeDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleConditionTypeDto create(VehicleConditionTypeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleConditionTypeDto update(Integer id, VehicleConditionTypeDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
