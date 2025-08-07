package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.WorkflowType;
import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.mapper.WorkflowTypeMapper;
import com.example.vehicleapi.repository.WorkflowTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/workflow-types")
@RequiredArgsConstructor
@Tag(name = "WorkflowType", description = "API for managing workflow-types")
public class WorkflowTypeController {
    private final WorkflowTypeRepository repository;
    private final WorkflowTypeMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<WorkflowTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public WorkflowTypeDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public WorkflowTypeDto create(@RequestBody WorkflowTypeDto dto) {
        WorkflowType entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public WorkflowTypeDto update(@PathVariable Long id, @RequestBody WorkflowTypeDto dto) {
        WorkflowType entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
