package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.Workflow;
import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.mapper.WorkflowMapper;
import com.example.vehicleapi.repository.WorkflowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow")
@RequiredArgsConstructor
@Tag(name = "Workflow", description = "API for managing workflows")
public class WorkflowController {
    private final WorkflowRepository repository;
    private final WorkflowMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public WorkflowDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowDto create(@RequestBody WorkflowDto dto) {
        Workflow entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public WorkflowDto update(@PathVariable Integer id, @RequestBody WorkflowDto dto) {
        Workflow entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
