package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.AuctionWatchDto;
import com.example.vehicleapi.mapper.AuctionWatchMapper;
import com.example.vehicleapi.repository.AuctionWatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionWatchService {
    private final AuctionWatchRepository repository;
    private final AuctionWatchMapper mapper;

    public List<AuctionWatchDto> getAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AuctionWatchDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    public AuctionWatchDto create(AuctionWatchDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public AuctionWatchDto update(Long id, AuctionWatchDto dto) {
        var entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
