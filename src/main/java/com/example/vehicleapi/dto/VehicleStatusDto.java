package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
public class VehicleStatusDto {
    @NotNull
    private Long id;
    private LocalDate statusDate;
    @Size(max = 255)
    private String notes;
}
