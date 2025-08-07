package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.WorkflowStepTypeDto;
import com.example.vehicleapi.service.WorkflowStepTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workflow-step-types")
@Validated
@Tag(name = "WorkflowStepType APIs", description = "Operations related to workflow step types")
public class WorkflowStepTypeController {

    private final WorkflowStepTypeService service;

    public WorkflowStepTypeController(WorkflowStepTypeService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkflowStepTypeDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkflowStepTypeDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public WorkflowStepTypeDto create(@Valid @RequestBody WorkflowStepTypeDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public WorkflowStepTypeDto update(@PathVariable Long id,
                                      @Valid @RequestBody WorkflowStepTypeDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
