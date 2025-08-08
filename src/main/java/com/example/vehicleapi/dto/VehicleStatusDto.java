package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "VehicleStatusDto model")
public class VehicleStatusDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Schema(description = "statusDate", example = "2024-01-15")
    private LocalDate statusDate;
    @Size(max = 255)
    @Schema(description = "notes", example = "notes_example")
    private String notes;
}
