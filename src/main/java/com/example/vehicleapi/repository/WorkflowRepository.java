package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.Workflow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowRepository extends JpaRepository<Workflow, Integer> {
}
