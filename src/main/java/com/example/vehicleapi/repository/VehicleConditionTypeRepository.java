package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.VehicleConditionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleConditionTypeRepository extends JpaRepository<VehicleConditionType, Integer> {
}
