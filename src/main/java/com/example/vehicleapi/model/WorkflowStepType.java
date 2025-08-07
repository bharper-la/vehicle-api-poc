package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workflow_step_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowStepType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @OneToMany(
            mappedBy = "workflowStepType",   // <-- must match the field name in your WorkflowStep entity
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Singular("workflowStep")
    private List<WorkflowStep> workflowStepList = new ArrayList<>();
}
