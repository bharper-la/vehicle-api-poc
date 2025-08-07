package com.example.vehicleapi.controller;

import com.example.vehicleapi.mapper.VehicleMetadataMapper;
import com.example.vehicleapi.repository.VehicleMetadataRepository;
import com.example.vehicleapi.dto.VehicleMetadataDto;
import com.example.vehicleapi.model.VehicleMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle-metadatas")
@RequiredArgsConstructor
@Tag(name = "VehicleMetadata", description = "API for managing vehicle-metadatas")
public class VehicleMetadataController {
    private final VehicleMetadataRepository repository;
    private final VehicleMetadataMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleMetadataDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public VehicleMetadataDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleMetadataDto create(@RequestBody VehicleMetadataDto dto) {
        VehicleMetadata entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public VehicleMetadataDto update(@PathVariable Long id, @RequestBody VehicleMetadataDto dto) {
        VehicleMetadata entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
