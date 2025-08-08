package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.service.VehicleStatusTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-status-type")
@RequiredArgsConstructor
@Tag(name = "VehicleStatusType", description = "API for managing vehicle-status-types")
public class VehicleStatusTypeController {

    private final VehicleStatusTypeService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<VehicleStatusTypeDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<VehicleStatusTypeDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<VehicleStatusTypeDto> create(@RequestBody VehicleStatusTypeDto dto) {
        VehicleStatusTypeDto saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<VehicleStatusTypeDto> update(@PathVariable Integer id, @RequestBody VehicleStatusTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
