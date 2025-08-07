package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.VehicleStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusRepository extends JpaRepository<VehicleStatus, Long> {
}
