package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowTypeDto;
import com.example.vehicleapi.service.WorkflowTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflow-type")
@RequiredArgsConstructor
@Tag(name = "WorkflowType", description = "API for managing workflow-types")
public class WorkflowTypeController {

    private final WorkflowTypeService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<WorkflowTypeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<WorkflowTypeDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<WorkflowTypeDto> create(@RequestBody WorkflowTypeDto dto) {
        WorkflowTypeDto created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<WorkflowTypeDto> update(@PathVariable Integer id, @RequestBody WorkflowTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
