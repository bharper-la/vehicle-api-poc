package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class WorkflowLogDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String message;
    private LocalDateTime createdAt;
}
