package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "WorkflowDto model")
public class WorkflowDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @NotNull
    @Size(max = 100)
    @Schema(description = "name", example = "John Doe")
    private String name;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
}
