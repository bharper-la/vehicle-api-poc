package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowDto;
import com.example.vehicleapi.service.WorkflowService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflow")
@RequiredArgsConstructor
@Tag(name = "Workflow", description = "API for managing workflows")
public class WorkflowController {

    private final WorkflowService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<WorkflowDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<WorkflowDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<WorkflowDto> create(@RequestBody WorkflowDto dto) {
        WorkflowDto saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<WorkflowDto> update(@PathVariable Integer id, @RequestBody WorkflowDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
