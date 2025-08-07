package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class VehicleMetadataDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String type;
    @Size(max = 255)
    private String data;
    private LocalDateTime createdAt;
}
