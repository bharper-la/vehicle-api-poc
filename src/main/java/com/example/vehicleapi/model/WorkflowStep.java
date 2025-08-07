package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_step")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowStep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;
    @ManyToOne
    @JoinColumn(name = "workflow_step_type_id")
    private WorkflowStepType stepType;
}