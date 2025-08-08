package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "ContactInfoDto model")
public class ContactInfoDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Email
    @Schema(description = "email", example = "user@example.com")
    private String email;
    @Size(max = 255)
    @Schema(description = "phoneAreaCode", example = "555-123-4567")
    private String phoneAreaCode;
    @Size(max = 255)
    @Schema(description = "phoneExchangeNumber", example = "555-123-4567")
    private String phoneExchangeNumber;
    @Size(max = 255)
    @Schema(description = "phoneUnitNumber", example = "555-123-4567")
    private String phoneUnitNumber;
    @Size(max = 255)
    @Schema(description = "phoneExtension", example = "555-123-4567")
    private String phoneExtension;
}
