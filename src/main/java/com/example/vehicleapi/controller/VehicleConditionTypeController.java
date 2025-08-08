package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.service.VehicleConditionTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-condition-type")
@RequiredArgsConstructor
@Tag(name = "VehicleConditionType", description = "API for managing vehicle-condition-types")
public class VehicleConditionTypeController {

    private final VehicleConditionTypeService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<VehicleConditionTypeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<VehicleConditionTypeDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<VehicleConditionTypeDto> create(@RequestBody VehicleConditionTypeDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<VehicleConditionTypeDto> update(@PathVariable Integer id, @RequestBody VehicleConditionTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
