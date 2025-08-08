package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Vehicle condition type DTO")
public class VehicleConditionTypeDto {
    @Schema(description = "ID", example = "1")
    private Integer id;

    @Schema(description = "Code", example = "EXCELLENT")
    private String code;

    @Schema(description = "Description", example = "Excellent condition")
    private String description;
}