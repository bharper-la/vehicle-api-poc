package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.AuctionFilterDto;
import com.example.vehicleapi.mapper.AuctionFilterMapper;
import com.example.vehicleapi.repository.AuctionFilterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionFilterService {
    private final AuctionFilterRepository repository;
    private final AuctionFilterMapper mapper;

    public List<AuctionFilterDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AuctionFilterDto getById(Integer id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public AuctionFilterDto create(AuctionFilterDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public AuctionFilterDto update(Integer id, AuctionFilterDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
