package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "contact_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "john.doe@example.com")
    private String email;
    @Schema(description = "TODO", example = "123")
    private String phoneAreaCode;
    @Schema(description = "TODO", example = "456")
    private String phoneExchangeNumber;
    @Schema(description = "TODO", example = "7890")
    private String phoneUnitNumber;
    @Schema(description = "TODO", example = "sample")
    private String phoneExtension;
    @OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> userList;
    @OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lead> leadList = new ArrayList<>();
}