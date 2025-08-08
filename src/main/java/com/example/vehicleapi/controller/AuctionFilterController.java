package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.AuctionFilter;
import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import com.example.vehicleapi.repository.AuctionFilterRepository;
import com.example.vehicleapi.service.AuctionFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auction-filter")
@RequiredArgsConstructor
@Tag(name = "AuctionFilter", description = "API for managing auction-filters")
public class AuctionFilterController {
    private final AuctionFilterService service;
    private final AuctionFilterMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<AuctionFilterDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public AuctionFilterDto getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<AuctionFilterDto> create(@RequestBody AuctionFilterDto dto) {
        AuctionFilterDto savedDto = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDto);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public AuctionFilterDto update(@PathVariable Integer id, @RequestBody AuctionFilterDto dto) {
        return service.update(id,dto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
