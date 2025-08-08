package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "WorkflowStepTypeDto model")
public class WorkflowStepTypeDto {
    @Schema(description = "id", example = "1")
    private Long id;
    @NotNull
    @Size(max = 100)
    @Schema(description = "name", example = "John Doe")
    private String name;
    @Size(max = 255)
    @Schema(description = "description", example = "description_example")
    private String description;
}
