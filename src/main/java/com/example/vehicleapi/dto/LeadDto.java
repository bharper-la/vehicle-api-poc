package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(description = "LeadDto model")
public class LeadDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @Size(max = 255)
    @Schema(description = "dealership", example = "dealership_example")
    private String dealership;
    @Size(max = 255)
    @Schema(description = "firstName", example = "John Doe")
    private String firstName;
    @Size(max = 255)
    @Schema(description = "lastName", example = "John Doe")
    private String lastName;
    @Email
    @Schema(description = "email", example = "user@example.com")
    private String email;
    @Size(max = 255)
    @Schema(description = "promoCode", example = "promoCode_example")
    private String promoCode;
    @Size(max = 255)
    @Schema(description = "referrer", example = "referrer_example")
    private String referrer;
    @Size(max = 255)
    @Schema(description = "status", example = "status_example")
    private String status;
    @Schema(description = "statusDate", example = "2024-01-15")
    private LocalDate statusDate;
    @Schema(description = "expirationDate", example = "2024-01-15")
    private LocalDate expirationDate;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
    @Schema(description = "updatedAt", example = "2024-01-15")
    private LocalDateTime updatedAt;
}
