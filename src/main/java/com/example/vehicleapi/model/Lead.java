package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "lead")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "Super Cars")
    private String dealership;
    @Schema(description = "TODO", example = "Clark")
    private String firstName;
    @Schema(description = "TODO", example = "Kent")
    private String lastName;
    @Schema(description = "TODO", example = "john.doe@example.com")
    private String email;
    @Schema(description = "TODO", example = "PROMO123")
    private String promoCode;
    @Schema(description = "TODO", example = "Daily Planet")
    private String referrer;
    @Schema(description = "TODO", example = "NEW")
    private String status;
    private LocalDate statusDate;
    private LocalDate expirationDate;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;
}