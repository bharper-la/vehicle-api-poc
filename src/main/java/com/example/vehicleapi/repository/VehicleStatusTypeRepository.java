package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.VehicleStatusType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleStatusTypeRepository extends JpaRepository<VehicleStatusType, Integer> {
}
