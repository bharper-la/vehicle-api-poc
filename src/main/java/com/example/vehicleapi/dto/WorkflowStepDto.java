package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class WorkflowStepDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String description;
    private LocalDateTime createdAt;
}
