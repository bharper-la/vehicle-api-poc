package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowLogDto;
import com.example.vehicleapi.service.WorkflowLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflow-log")
@RequiredArgsConstructor
@Tag(name = "WorkflowLog", description = "API for managing workflow-logs")
public class WorkflowLogController {

    private final WorkflowLogService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<WorkflowLogDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<WorkflowLogDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<WorkflowLogDto> create(@RequestBody WorkflowLogDto dto) {
        WorkflowLogDto saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<WorkflowLogDto> update(@PathVariable Integer id, @RequestBody WorkflowLogDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
