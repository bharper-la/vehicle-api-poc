package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "VehicleConditionTypeDto model")
public class VehicleConditionTypeDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @NotNull
    @Size(max = 50)
    @Schema(description = "code", example = "code_example")
    private String code;
    @Size(max = 255)
    @Schema(description = "description", example = "description_example")
    private String description;
}
