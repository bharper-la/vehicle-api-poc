package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class ContactInfoDto {
    @NotNull
    private Long id;
    @Email
    private String email;
    @Size(max = 255)
    private String phoneAreaCode;
    @Size(max = 255)
    private String phoneExchangeNumber;
    @Size(max = 255)
    private String phoneUnitNumber;
    @Size(max = 255)
    private String phoneExtension;
}
