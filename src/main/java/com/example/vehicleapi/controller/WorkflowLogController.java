package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.WorkflowLog;
import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.mapper.WorkflowLogMapper;
import com.example.vehicleapi.repository.WorkflowLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow-log")
@RequiredArgsConstructor
@Tag(name = "WorkflowLog", description = "API for managing workflow-logs")
public class WorkflowLogController {
    private final WorkflowLogRepository repository;
    private final WorkflowLogMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowLogDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public WorkflowLogDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowLogDto create(@RequestBody WorkflowLogDto dto) {
        WorkflowLog entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public WorkflowLogDto update(@PathVariable Long id, @RequestBody WorkflowLogDto dto) {
        WorkflowLog entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
