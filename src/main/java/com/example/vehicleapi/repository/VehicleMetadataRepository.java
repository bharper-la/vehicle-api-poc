package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.VehicleMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMetadataRepository extends JpaRepository<VehicleMetadata, Integer> {
}
