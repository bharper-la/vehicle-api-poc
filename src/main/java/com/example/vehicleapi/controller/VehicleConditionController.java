package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.service.VehicleConditionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-condition")
@RequiredArgsConstructor
@Tag(name = "VehicleCondition", description = "API for managing vehicle-conditions")
public class VehicleConditionController {

    private final VehicleConditionService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<VehicleConditionDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<VehicleConditionDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<VehicleConditionDto> create(@RequestBody VehicleConditionDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<VehicleConditionDto> update(@PathVariable Integer id, @RequestBody VehicleConditionDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
