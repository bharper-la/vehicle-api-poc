package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.WorkflowQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkflowQueueRepository extends JpaRepository<WorkflowQueue, Long> {
}
