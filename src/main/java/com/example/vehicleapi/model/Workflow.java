package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "workflow")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
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