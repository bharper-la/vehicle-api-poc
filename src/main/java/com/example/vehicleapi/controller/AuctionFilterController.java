package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import com.example.vehicleapi.repository.AuctionFilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auction-filter")
@RequiredArgsConstructor
@Tag(name = "AuctionFilter", description = "API for managing auction-filters")
public class AuctionFilterController {
    private final AuctionFilterRepository repository;
    private final AuctionFilterMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<AuctionFilterDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public AuctionFilterDto getById(@PathVariable Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public AuctionFilterDto create(@RequestBody AuctionFilterDto dto) {
        AuctionFilter entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public AuctionFilterDto update(@PathVariable Integer id, @RequestBody AuctionFilterDto dto) {
        AuctionFilter entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
