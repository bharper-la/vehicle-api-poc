package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.service.WorkflowStepTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workflow-step-type")
@Validated
@Tag(name = "WorkflowStepType APIs", description = "Operations related to workflow step types")
public class WorkflowStepTypeController {

    private final WorkflowStepTypeService service;

    public WorkflowStepTypeController(WorkflowStepTypeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<WorkflowStepTypeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowStepTypeDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<WorkflowStepTypeDto> create(@Valid @RequestBody WorkflowStepTypeDto dto) {
        WorkflowStepTypeDto created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkflowStepTypeDto> update(@PathVariable Integer id,
                                                      @Valid @RequestBody WorkflowStepTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
