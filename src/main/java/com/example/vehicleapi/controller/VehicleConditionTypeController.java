package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.VehicleConditionType;
import com.example.vehicleapi.dto.VehicleConditionTypeDto;
import com.example.vehicleapi.mapper.VehicleConditionTypeMapper;
import com.example.vehicleapi.repository.VehicleConditionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle-condition-types")
@RequiredArgsConstructor
@Tag(name = "VehicleConditionType", description = "API for managing vehicle-condition-types")
public class VehicleConditionTypeController {
    private final VehicleConditionTypeRepository repository;
    private final VehicleConditionTypeMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleConditionTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        return repository.findAll();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public VehicleConditionTypeDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleConditionTypeDto create(@RequestBody VehicleConditionTypeDto dto) {
        VehicleConditionType entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public VehicleConditionTypeDto update(@PathVariable Long id, @RequestBody VehicleConditionTypeDto dto) {
        VehicleConditionType entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
