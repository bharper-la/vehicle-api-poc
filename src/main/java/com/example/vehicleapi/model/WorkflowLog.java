package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;
}