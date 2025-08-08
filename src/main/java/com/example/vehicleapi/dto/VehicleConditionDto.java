package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "VehicleConditionDto model")
public class VehicleConditionDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Schema(description = "conditionDate", example = "2024-01-15")
    private LocalDate conditionDate;
    @Size(max = 255)
    @Schema(description = "comments", example = "comments_example")
    private String comments;
}
