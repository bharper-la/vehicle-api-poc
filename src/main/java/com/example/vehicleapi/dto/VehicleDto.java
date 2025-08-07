package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class VehicleDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 50)
    private String vin;
    @Size(max = 255)
    private String make;
    @Size(max = 255)
    private String model;
    @NotNull
    private Integer year;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
