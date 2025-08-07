package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.mapper.LeadMapper;
import com.example.vehicleapi.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeadService {
    private final LeadRepository repository;
    private final LeadMapper mapper;

    public List<LeadDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public LeadDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public LeadDto create(LeadDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public LeadDto update(Integer id, LeadDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
