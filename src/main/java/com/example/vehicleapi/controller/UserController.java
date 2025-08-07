package com.example.vehicleapi.controller;

import com.example.vehicleapi.dto.UserDto;
import com.example.vehicleapi.mapper.UserMapper;
import com.example.vehicleapi.repository.UserRepository;
import com.example.vehicleapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "API for managing users")
public class UserController {
    private final UserRepository repository;
    private final UserMapper mapper;

    @GetMapping
    @Operation(summary = "Get all records")
    public List<UserDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
        
    }

    @GetMapping("/<built-in function id>")
    @Operation(summary = "Get by ID")
    public UserDto getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @PostMapping
    @Operation(summary = "Create new record")
    public UserDto create(@RequestBody UserDto dto) {
        User entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @PutMapping("/<built-in function id>")
    @Operation(summary = "Update record")
    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
        User entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @DeleteMapping("/<built-in function id>")
    @Operation(summary = "Delete record")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
