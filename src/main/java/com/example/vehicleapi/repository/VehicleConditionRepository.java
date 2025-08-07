package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.VehicleCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleConditionRepository extends JpaRepository<VehicleCondition, Integer> {
}
