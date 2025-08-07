package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class WorkflowDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 100)
    private String name;
    private LocalDateTime createdAt;
}
