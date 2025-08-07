package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.WorkflowStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowStepRepository extends JpaRepository<WorkflowStep, Integer> {
}
