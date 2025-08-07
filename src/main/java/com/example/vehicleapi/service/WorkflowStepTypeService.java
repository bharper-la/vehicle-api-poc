package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.mapper.WorkflowStepTypeMapper;
import com.example.vehicleapi.repository.WorkflowStepTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowStepTypeService {
    private final WorkflowStepTypeRepository repository;
    private final WorkflowStepTypeMapper mapper;

    public List<WorkflowStepTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowStepTypeDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowStepTypeDto create(WorkflowStepTypeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowStepTypeDto update(Long id, WorkflowStepTypeDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
