package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "WorkflowStepDto model")
public class WorkflowStepDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Size(max = 255)
    @Schema(description = "description", example = "description_example")
    private String description;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
}
