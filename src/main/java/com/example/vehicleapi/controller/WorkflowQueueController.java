package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.WorkflowQueue;
import com.example.vehicleapi.dto.WorkflowQueueDto;
import com.example.vehicleapi.mapper.WorkflowQueueMapper;
import com.example.vehicleapi.repository.WorkflowQueueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow-queues")
@RequiredArgsConstructor
@Tag(name = "WorkflowQueue", description = "API for managing workflow-queues")
public class WorkflowQueueController {
    private final WorkflowQueueRepository repository;
    private final WorkflowQueueMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowQueueDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public WorkflowQueueDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowQueueDto create(@RequestBody WorkflowQueueDto dto) {
        WorkflowQueue entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public WorkflowQueueDto update(@PathVariable Long id, @RequestBody WorkflowQueueDto dto) {
        WorkflowQueue entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
