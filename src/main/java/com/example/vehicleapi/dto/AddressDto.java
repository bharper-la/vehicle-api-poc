package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "AddressDto model")
public class AddressDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Size(max = 255)
    @Schema(description = "line1", example = "line1_example")
    private String line1;
    @Size(max = 255)
    @Schema(description = "line2", example = "line2_example")
    private String line2;
    @Size(max = 255)
    @Schema(description = "city", example = "Springfield")
    private String city;
    @Size(max = 255)
    @Schema(description = "state", example = "CA")
    private String state;
    @Size(max = 255)
    @Schema(description = "postalCode", example = "postalCode_example")
    private String postalCode;
}
