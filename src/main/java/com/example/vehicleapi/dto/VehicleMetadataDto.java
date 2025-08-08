package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "VehicleMetadataDto model")
public class VehicleMetadataDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Size(max = 255)
    @Schema(description = "type", example = "type_example")
    private String type;
    @Size(max = 255)
    @Schema(description = "data", example = "data_example")
    private String data;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
}
