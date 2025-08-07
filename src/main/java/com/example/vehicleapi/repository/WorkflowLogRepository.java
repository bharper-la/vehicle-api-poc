package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.WorkflowLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowLogRepository extends JpaRepository<WorkflowLog, Long> {
}
