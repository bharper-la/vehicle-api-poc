package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.Vehicle;
import com.example.vehicleapi.dto.VehicleDto;
import com.example.vehicleapi.mapper.VehicleMapper;
import com.example.vehicleapi.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/vehicle")
@RequiredArgsConstructor
@Tag(name = "Vehicle", description = "API for managing vehicles")
public class VehicleController {
    private final VehicleRepository repository;
    private final VehicleMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<VehicleDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public VehicleDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public VehicleDto create(@RequestBody VehicleDto dto) {
        Vehicle entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public VehicleDto update(@PathVariable Long id, @RequestBody VehicleDto dto) {
        Vehicle entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
