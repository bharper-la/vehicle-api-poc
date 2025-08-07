package com.example.vehicleapi.controller;

import com.example.vehicleapi.model.ContactInfo;
import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.mapper.ContactInfoMapper;
import com.example.vehicleapi.repository.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contact-infos")
@RequiredArgsConstructor
@Tag(name = "ContactInfo", description = "API for managing contact-infos")
public class ContactInfoController {
    private final ContactInfoRepository repository;
    private final ContactInfoMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<ContactInfoDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public ContactInfoDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public ContactInfoDto create(@RequestBody ContactInfoDto dto) {
        ContactInfo entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public ContactInfoDto update(@PathVariable Long id, @RequestBody ContactInfoDto dto) {
        ContactInfo entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
