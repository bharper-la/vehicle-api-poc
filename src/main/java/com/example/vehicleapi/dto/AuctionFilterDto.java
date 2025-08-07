package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class AuctionFilterDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String filterData;
    private LocalDateTime createdAt;
}
