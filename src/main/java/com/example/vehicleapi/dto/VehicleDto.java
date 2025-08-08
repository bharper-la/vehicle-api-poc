package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "VehicleDto model")
public class VehicleDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @NotNull
    @Size(max = 50)
    @Schema(description = "vin", example = "1FTFW3L80RKD57160")
    private String vin;
    @Size(max = 255)
    @Schema(description = "make", example = "Ford")
    private String make;
    @Size(max = 255)
    @Schema(description = "model", example = "F-150")
    private String model;
    @NotNull
    @Schema(description = "year", example = "2024")
    private Integer year;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
    @Schema(description = "updatedAt", example = "2024-01-15")
    private LocalDateTime updatedAt;
    @Schema(description = "List of vehicle conditions")
    private List<VehicleConditionDto> vehicleConditionList;

    @Schema(description = "List of vehicle statuses")
    private List<VehicleStatusDto> vehicleStatuses;

    @Schema(description = "List of vehicle metadata")
    private List<VehicleMetadataDto> vehicleMetadata;
}
