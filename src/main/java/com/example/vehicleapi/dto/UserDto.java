package com.example.vehicleapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "UserDto model")
public class UserDto {
    @NotNull
    @Schema(description = "id", example = "1")
    private Long id;
    @NotNull
    @Size(max = 100)
    @Schema(description = "login", example = "login_example")
    private String login;
    @NotNull
    @Size(max = 100)
    @Schema(description = "password", example = "password_example")
    private String password;
    @Schema(description = "enabled", example = "enabled_example")
    private Boolean enabled;
    @Schema(description = "createdAt", example = "2024-01-15")
    private LocalDateTime createdAt;
    @Schema(description = "updatedAt", example = "2024-01-15")
    private LocalDateTime updatedAt;
}
