package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.Lead;
import com.example.vehicleapi.dto.LeadDto;
import com.example.vehicleapi.mapper.LeadMapper;
import com.example.vehicleapi.repository.LeadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/lead")
@RequiredArgsConstructor
@Tag(name = "Lead", description = "API for managing leads")
public class LeadController {
    private final LeadRepository repository;
    private final LeadMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<LeadDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public LeadDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public LeadDto create(@RequestBody LeadDto dto) {
        Lead entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public LeadDto update(@PathVariable Integer id, @RequestBody LeadDto dto) {
        Lead entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
