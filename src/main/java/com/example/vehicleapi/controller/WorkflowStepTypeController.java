package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.WorkflowStepType;
import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.mapper.WorkflowStepTypeMapper;
import com.example.vehicleapi.repository.WorkflowStepTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow-step-types")
@RequiredArgsConstructor
@Tag(name = "WorkflowStepType", description = "API for managing workflow-step-types")
public class WorkflowStepTypeController {
    private final WorkflowStepTypeRepository repository;
    private final WorkflowStepTypeMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowStepTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public WorkflowStepTypeDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowStepTypeDto create(@RequestBody WorkflowStepTypeDto dto) {
        WorkflowStepType entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public WorkflowStepTypeDto update(@PathVariable Long id, @RequestBody WorkflowStepTypeDto dto) {
        WorkflowStepType entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
