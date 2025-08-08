package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "WorkflowLogDto model")
public class WorkflowLogDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Size(max = 255)
    @Schema(description = "message", example = "message_example")
    private String message;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
}
