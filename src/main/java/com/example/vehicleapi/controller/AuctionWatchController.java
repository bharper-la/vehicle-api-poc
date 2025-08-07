package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.AuctionWatch;
import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.mapper.AuctionWatchMapper;
import com.example.vehicleapi.repository.AuctionWatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auction-watchs")
@RequiredArgsConstructor
@Tag(name = "AuctionWatch", description = "API for managing auction-watchs")
public class AuctionWatchController {
    private final AuctionWatchRepository repository;
    private final AuctionWatchMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<AuctionWatchDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();

    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public AuctionWatchDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public AuctionWatchDto create(@RequestBody AuctionWatchDto dto) {
        AuctionWatch entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public AuctionWatchDto update(@PathVariable Long id, @RequestBody AuctionWatchDto dto) {
        AuctionWatch entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
