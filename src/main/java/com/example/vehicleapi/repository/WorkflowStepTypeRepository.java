package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.WorkflowStepType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowStepTypeRepository extends JpaRepository<WorkflowStepType, Integer> {
}
