package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "workflow")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "Default Workflow")
    private String name;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "workflow_type_id")
    private WorkflowType workflowType;
    @OneToMany(mappedBy = "workflow")
    private List<WorkflowStep> workflow_stepList;
    @OneToMany(mappedBy = "workflow")
    private List<WorkflowLog> workflow_logList;
    @OneToMany(mappedBy = "workflow")
    private List<WorkflowQueue> workflow_queueList;
}