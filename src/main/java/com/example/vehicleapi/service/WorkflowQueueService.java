package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.mapper.WorkflowQueueMapper;
import com.example.vehicleapi.repository.WorkflowQueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowQueueService {
    private final WorkflowQueueRepository repository;
    private final WorkflowQueueMapper mapper;

    public List<WorkflowQueueDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowQueueDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowQueueDto create(WorkflowQueueDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowQueueDto update(Integer id, WorkflowQueueDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
