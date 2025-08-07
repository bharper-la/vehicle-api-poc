package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.mapper.WorkflowMapper;
import com.example.vehicleapi.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowService {
    private final WorkflowRepository repository;
    private final WorkflowMapper mapper;

    public List<WorkflowDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowDto create(WorkflowDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowDto update(Long id, WorkflowDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
