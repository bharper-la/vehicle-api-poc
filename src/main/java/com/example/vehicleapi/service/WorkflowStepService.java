package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.mapper.WorkflowStepMapper;
import com.example.vehicleapi.repository.WorkflowStepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowStepService {
    private final WorkflowStepRepository repository;
    private final WorkflowStepMapper mapper;

    public List<WorkflowStepDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowStepDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowStepDto create(WorkflowStepDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowStepDto update(Integer id, WorkflowStepDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
