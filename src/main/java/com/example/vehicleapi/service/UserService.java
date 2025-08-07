package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.UserDto;
import com.example.vehicleapi.mapper.UserMapper;
import com.example.vehicleapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public List<UserDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public UserDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public UserDto create(UserDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UserDto update(Long id, UserDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
