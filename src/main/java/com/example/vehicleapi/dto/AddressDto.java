package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class AddressDto {
    @NotNull
    private Long id;
    @Size(max = 255)
    private String line1;
    @Size(max = 255)
    private String line2;
    @Size(max = 255)
    private String city;
    @Size(max = 255)
    private String state;
    @Size(max = 255)
    private String postalCode;
}
