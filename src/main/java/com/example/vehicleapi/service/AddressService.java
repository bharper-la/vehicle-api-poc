package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.AddressDto;
import com.example.vehicleapi.mapper.AddressMapper;
import com.example.vehicleapi.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository repository;
    private final AddressMapper mapper;

    public List<AddressDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AddressDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public AddressDto create(AddressDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public AddressDto update(Long id, AddressDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
