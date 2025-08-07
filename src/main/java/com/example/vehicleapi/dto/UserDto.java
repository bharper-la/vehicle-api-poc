package com.example.vehicleapi.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Data
public class UserDto {
    @NotNull
    private Long id;
    @NotNull
    @Size(max = 100)
    private String login;
    @NotNull
    @Size(max = 100)
    private String password;
    private Boolean enabled;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
