package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workflow_step_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class WorkflowStepType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;

    @Schema(description = "TODO", example = "Default Workflow")
    private String name;

    @Schema(description = "TODO", example = "Standard vehicle processing workflow")
    private String description;

    @OneToMany(
            mappedBy = "workflowStepType",   // <-- must match the field name in your WorkflowStep entity
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Singular("workflowStep")
    private List<WorkflowStep> workflowStepList = new ArrayList<>();
}