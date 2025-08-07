package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class VehicleStatusTypeDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 50)
    private String code;
    @Size(max = 255)
    private String description;
}
