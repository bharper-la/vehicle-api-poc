package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.VehicleStatusType;
import com.example.vehicleapi.dto.VehicleStatusTypeDto;
import com.example.vehicleapi.mapper.VehicleStatusTypeMapper;
import com.example.vehicleapi.repository.VehicleStatusTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle-status-types")
@RequiredArgsConstructor
@Tag(name = "VehicleStatusType", description = "API for managing vehicle-status-types")
public class VehicleStatusTypeController {
    private final VehicleStatusTypeRepository repository;
    private final VehicleStatusTypeMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleStatusTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public VehicleStatusTypeDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleStatusTypeDto create(@RequestBody VehicleStatusTypeDto dto) {
        VehicleStatusType entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public VehicleStatusTypeDto update(@PathVariable Long id, @RequestBody VehicleStatusTypeDto dto) {
        VehicleStatusType entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
