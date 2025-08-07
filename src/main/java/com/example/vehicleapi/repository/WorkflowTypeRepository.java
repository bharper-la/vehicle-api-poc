package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.WorkflowType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowTypeRepository extends JpaRepository<WorkflowType, Long> {
}
