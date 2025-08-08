package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.service.VehicleMetadataService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle-metadata")
@RequiredArgsConstructor
@Tag(name = "VehicleMetadata", description = "API for managing vehicle-metadatas")
public class VehicleMetadataController {

    private final VehicleMetadataService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<VehicleMetadataDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<VehicleMetadataDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<VehicleMetadataDto> create(@RequestBody VehicleMetadataDto dto) {
        VehicleMetadataDto saved = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<VehicleMetadataDto> update(@PathVariable Integer id, @RequestBody VehicleMetadataDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
