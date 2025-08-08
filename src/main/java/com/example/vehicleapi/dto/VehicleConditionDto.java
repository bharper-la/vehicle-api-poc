package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Vehicle Condition DTO")
public class VehicleConditionDto {

    @Schema(description = "ID", example = "1")
    private Integer id;

    @Schema(description = "Vehicle ID", example = "5")
    private Integer vehicleId;

    @Schema(description = "Condition date", example = "2024-01-15")
    private LocalDate conditionDate;

    @Schema(description = "Condition comments", example = "Very clean inside and out")
    private String comments;

    @Schema(description = "Vehicle condition type")
    private VehicleConditionTypeDto conditionType;
}
