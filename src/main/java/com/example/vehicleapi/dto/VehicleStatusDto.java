package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "Vehicle Status DTO")
public class VehicleStatusDto {

    @Schema(description = "ID", example = "1")
    private Integer id;

    @Schema(description = "Vehicle ID", example = "5")
    private Integer vehicleId;

    @Schema(description = "Status date", example = "2024-01-15")
    private LocalDate statusDate;

    @Schema(description = "Status notes", example = "Checked into lot")
    private String notes;

    @Schema(description = "Vehicle status type")
    private VehicleStatusTypeDto statusType;
}
