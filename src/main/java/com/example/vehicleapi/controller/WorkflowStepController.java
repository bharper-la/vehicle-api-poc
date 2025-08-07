package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.WorkflowStep;
import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.mapper.WorkflowStepMapper;
import com.example.vehicleapi.repository.WorkflowStepRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow-steps")
@RequiredArgsConstructor
@Tag(name = "WorkflowStep", description = "API for managing workflow-steps")
public class WorkflowStepController {
    private final WorkflowStepRepository repository;
    private final WorkflowStepMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowStepDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public WorkflowStepDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowStepDto create(@RequestBody WorkflowStepDto dto) {
        WorkflowStep entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public WorkflowStepDto update(@PathVariable Long id, @RequestBody WorkflowStepDto dto) {
        WorkflowStep entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
