package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.Address;
import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.mapper.AddressMapper;
import com.example.vehicleapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Tag(name = "Address", description = "API for managing addresss")
public class AddressController {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<AddressDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public AddressDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public AddressDto create(@RequestBody AddressDto dto) {
        Address entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public AddressDto update(@PathVariable Integer id, @RequestBody AddressDto dto) {
        Address entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
