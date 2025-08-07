package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.mapper.VehicleConditionMapper;
import com.example.vehicleapi.repository.VehicleConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleConditionService {
    private final VehicleConditionRepository repository;
    private final VehicleConditionMapper mapper;

    public List<VehicleConditionDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public VehicleConditionDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public VehicleConditionDto create(VehicleConditionDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public VehicleConditionDto update(Integer id, VehicleConditionDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
