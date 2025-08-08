package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowStepDto;
import com.example.vehicleapi.service.WorkflowStepService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflow-step")
@RequiredArgsConstructor
@Tag(name = "WorkflowStep", description = "API for managing workflow-steps")
public class WorkflowStepController {

    private final WorkflowStepService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<WorkflowStepDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<WorkflowStepDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<WorkflowStepDto> create(@RequestBody WorkflowStepDto dto) {
        WorkflowStepDto created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<WorkflowStepDto> update(@PathVariable Integer id, @RequestBody WorkflowStepDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
