package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.service.VehicleStatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-status")
@RequiredArgsConstructor
@Tag(name = "VehicleStatus", description = "API for managing vehicle-statuses")
public class VehicleStatusController {

    private final VehicleStatusService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<VehicleStatusDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<VehicleStatusDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<VehicleStatusDto> create(@RequestBody VehicleStatusDto dto) {
        VehicleStatusDto saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<VehicleStatusDto> update(@PathVariable Integer id, @RequestBody VehicleStatusDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
