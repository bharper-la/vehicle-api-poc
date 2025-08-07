package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "workflow_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class WorkflowType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "Default Workflow")
    private String name;
    @Schema(description = "TODO", example = "Standard vehicle processing workflow")
    private String description;
    @OneToMany(mappedBy = "workflowType")
    @Singular("workflow")
    private List<Workflow> workflowList;
}