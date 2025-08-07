package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.mapper.WorkflowTypeMapper;
import com.example.vehicleapi.repository.WorkflowTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowTypeService {
    private final WorkflowTypeRepository repository;
    private final WorkflowTypeMapper mapper;

    public List<WorkflowTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowTypeDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowTypeDto create(WorkflowTypeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowTypeDto update(Long id, WorkflowTypeDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
