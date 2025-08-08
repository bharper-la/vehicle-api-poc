package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.service.AuctionWatchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction-watch")
@RequiredArgsConstructor
@Tag(name = "AuctionWatch", description = "API for managing auction-watchs")
public class AuctionWatchController {

    private final AuctionWatchService service;

    @GetMapping
    @Operation(summary = "Get all records")
    public ResponseEntity<List<AuctionWatchDto>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get by ID")
    public ResponseEntity<AuctionWatchDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ResponseEntity<AuctionWatchDto> create(@RequestBody AuctionWatchDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update record")
    public ResponseEntity<AuctionWatchDto> update(@PathVariable Integer id, @RequestBody AuctionWatchDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete record")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
