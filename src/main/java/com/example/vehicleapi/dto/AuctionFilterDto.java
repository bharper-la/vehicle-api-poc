package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "AuctionFilterDto model")
public class AuctionFilterDto {
    @Schema(description = "id", example = "1")
    private Integer id;

    @Schema(description = "userId", example = "5")
    private Integer userId;

    @Schema(description = "type", implementation = AuctionFilterTypeDto.class)
    private AuctionFilterTypeDto type;

    @Schema(description = "filterData", example = "{\"make\":\"Toyota\",\"year\":2022}")
    private String filterData;

    @Schema(description = "createdAt", example = "2024-01-15T00:00:00")
    private LocalDateTime createdAt;
}
