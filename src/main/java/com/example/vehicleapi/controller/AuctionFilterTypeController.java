package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.service.AuctionFilterTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auction-filter-type")
@RequiredArgsConstructor
@Tag(name = "AuctionFilterType", description = "API for managing auction filter types")
public class AuctionFilterTypeController {

    private final AuctionFilterTypeService service;

    @GetMapping
    @Operation(summary = "Get all auction filter types")
    public List<AuctionFilterTypeDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get auction filter type by ID")
    public AuctionFilterTypeDto getById(@PathVariable Integer id) {
        return service.findById(id);
    }

    @PostMapping
    @Operation(summary = "Create or update an auction filter type")
    public AuctionFilterTypeDto save(@RequestBody AuctionFilterTypeDto dto) {
        return service.save(dto);
    }
}
