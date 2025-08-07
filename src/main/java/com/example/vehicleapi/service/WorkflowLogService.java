package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.mapper.WorkflowLogMapper;
import com.example.vehicleapi.repository.WorkflowLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkflowLogService {
    private final WorkflowLogRepository repository;
    private final WorkflowLogMapper mapper;

    public List<WorkflowLogDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public WorkflowLogDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public WorkflowLogDto create(WorkflowLogDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public WorkflowLogDto update(Integer id, WorkflowLogDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
