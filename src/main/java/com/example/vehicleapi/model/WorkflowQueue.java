package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_queue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkflowQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String status;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;
}