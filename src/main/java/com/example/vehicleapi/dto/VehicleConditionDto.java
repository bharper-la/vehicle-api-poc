package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
public class VehicleConditionDto {
    @NotNull
    private Long id;
    private LocalDate conditionDate;
    @Size(max = 255)
    private String comments;
}
