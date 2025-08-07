package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.exception.EntityNotFoundException;
import com.example.vehicleapi.mapper.WorkflowStepTypeMapper;
import com.example.vehicleapi.repository.WorkflowStepTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkflowStepTypeService {

    private final WorkflowStepTypeRepository repository;
    private final WorkflowStepTypeMapper mapper;

    public List<WorkflowStepTypeDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public WorkflowStepTypeDto findById(Integer id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("WorkflowStepType not found: " + id));
    }

    public WorkflowStepTypeDto create(WorkflowStepTypeDto dto) {
        var entity = mapper.toEntity(dto);
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public WorkflowStepTypeDto update(Integer id, WorkflowStepTypeDto dto) {
        var existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("WorkflowStepType not found: " + id));
        var entity = mapper.toEntity(dto);
        entity.setId(existing.getId());
        var saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
