package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Vehicle status type DTO")
public class VehicleStatusTypeDto {
    @Schema(description = "ID", example = "1")
    private Integer id;

    @Schema(description = "Code", example = "IN_STOCK")
    private String code;

    @Schema(description = "Description", example = "In stock")
    private String description;
}