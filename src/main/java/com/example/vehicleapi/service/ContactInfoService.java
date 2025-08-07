package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.ContactInfoDto;
import com.example.vehicleapi.mapper.ContactInfoMapper;
import com.example.vehicleapi.repository.ContactInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactInfoService {
    private final ContactInfoRepository repository;
    private final ContactInfoMapper mapper;

    public List<ContactInfoDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public ContactInfoDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public ContactInfoDto create(ContactInfoDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public ContactInfoDto update(Integer id, ContactInfoDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
