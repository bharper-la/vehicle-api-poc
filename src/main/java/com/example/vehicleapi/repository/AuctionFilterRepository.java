package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.AuctionFilter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionFilterRepository extends JpaRepository<AuctionFilter, Long> {
}
