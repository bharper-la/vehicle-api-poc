package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "AuctionFilterTypeDto model")
public class AuctionFilterTypeDto {
    @Schema(description = "id", example = "1")
    private Integer id;

    @Schema(description = "filterType", example = "deal_type")
    private String filterType;

    @Schema(description = "createdAt", example = "2024-01-15T00:00:00")
    private LocalDateTime createdAt;
}