package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.VehicleStatus;
import com.example.vehicleapi.dto.VehicleStatusDto;
import com.example.vehicleapi.mapper.VehicleStatusMapper;
import com.example.vehicleapi.repository.VehicleStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle-status")
@RequiredArgsConstructor
@Tag(name = "VehicleStatus", description = "API for managing vehicle-statuss")
public class VehicleStatusController {
    private final VehicleStatusRepository repository;
    private final VehicleStatusMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleStatusDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public VehicleStatusDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleStatusDto create(@RequestBody VehicleStatusDto dto) {
        VehicleStatus entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public VehicleStatusDto update(@PathVariable Integer id, @RequestBody VehicleStatusDto dto) {
        VehicleStatus entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
