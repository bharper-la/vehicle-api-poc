package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.VehicleCondition;
import com.example.vehicleapi.dto.VehicleConditionDto;
import com.example.vehicleapi.mapper.VehicleConditionMapper;
import com.example.vehicleapi.repository.VehicleConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle-condition")
@RequiredArgsConstructor
@Tag(name = "VehicleCondition", description = "API for managing vehicle-conditions")
public class VehicleConditionController {
    private final VehicleConditionRepository repository;
    private final VehicleConditionMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleConditionDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public VehicleConditionDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleConditionDto create(@RequestBody VehicleConditionDto dto) {
        VehicleCondition entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public VehicleConditionDto update(@PathVariable Integer id, @RequestBody VehicleConditionDto dto) {
        VehicleCondition entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
