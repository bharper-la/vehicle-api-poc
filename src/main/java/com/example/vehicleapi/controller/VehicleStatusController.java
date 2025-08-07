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

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public VehicleStatusDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleStatusDto create(@RequestBody VehicleStatusDto dto) {
        VehicleStatus entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public VehicleStatusDto update(@PathVariable Long id, @RequestBody VehicleStatusDto dto) {
        VehicleStatus entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
