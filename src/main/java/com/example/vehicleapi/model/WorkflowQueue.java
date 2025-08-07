package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "workflow_queue")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class WorkflowQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "NEW")
    private String status;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "workflow_id")
    private Workflow workflow;
}