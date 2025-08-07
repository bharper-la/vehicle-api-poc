package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "1HGCM82633A004352")
    private String vin;
    @Schema(description = "TODO", example = "Honda")
    private String make;
    @Schema(description = "TODO", example = "Accord")
    private String model;
    @Column(name = "vehicle_year")
    @Schema(description = "TODO", example = "2020")
    private Integer year;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleCondition> vehicle_conditionList;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleStatus> vehicleStatuses;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleMetadata> vehicleMetadata;
}