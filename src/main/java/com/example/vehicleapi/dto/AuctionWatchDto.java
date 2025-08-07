package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class AuctionWatchDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String watchData;
    private LocalDateTime createdAt;
}
