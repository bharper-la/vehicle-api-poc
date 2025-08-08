package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.model.Address;
import com.example.vehicleapi.mapper.AddressMapper;
import com.example.vehicleapi.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Tag(name = "Address", description = "API for managing addresses")
public class AddressController {

    private final AddressService service;
    private final AddressMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<AddressDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<AddressDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<AddressDto> create(@RequestBody AddressDto dto) {
        AddressDto created = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<AddressDto> update(@PathVariable Integer id, @RequestBody AddressDto dto) {
        AddressDto updated = service.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
