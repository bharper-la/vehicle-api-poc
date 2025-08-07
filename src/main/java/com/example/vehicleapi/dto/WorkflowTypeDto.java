package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class WorkflowTypeDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 100)
    private String name;
    @Size(max = 255)
    private String description;
}
