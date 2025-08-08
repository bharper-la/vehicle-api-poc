package com.example.vehicleapi.service;

import com.example.vehicleapi.dto.AuctionFilterTypeDto;
import com.example.vehicleapi.mapper.AuctionFilterTypeMapper;
import com.example.vehicleapi.repository.AuctionFilterTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionFilterTypeService {
    private final AuctionFilterTypeRepository repository;
    private final AuctionFilterTypeMapper mapper;

    public List<AuctionFilterTypeDto> findAll() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public AuctionFilterTypeDto findById(Integer id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    public AuctionFilterTypeDto save(AuctionFilterTypeDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }
}
