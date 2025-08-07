package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "workflow_step_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowStepType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "workflow_step_type")
    private List<WorkflowStep> workflow_stepList;
}