package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "123 Main St")
    private String line1;
    @Schema(description = "TODO", example = "Apt 2")
    private String line2;
    @Schema(description = "TODO", example = "Metropolis")
    private String city;
    @Schema(description = "TODO", example = "NY")
    private String state;
    @Schema(description = "TODO", example = "12345")
    private String postalCode;
    @OneToMany(mappedBy = "address")
    @Singular("user")
    private List<User> userList;
}