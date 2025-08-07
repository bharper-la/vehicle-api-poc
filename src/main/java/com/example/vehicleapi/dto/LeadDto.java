package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class LeadDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String dealership;
    @Size(max = 255)
    private String firstName;
    @Size(max = 255)
    private String lastName;
    @Email
    private String email;
    @Size(max = 255)
    private String promoCode;
    @Size(max = 255)
    private String referrer;
    @Size(max = 255)
    private String status;
    private LocalDate statusDate;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
