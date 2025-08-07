package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "workflow_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "workflowType")
    @Singular("workflow")
    private List<Workflow> workflowList;
}