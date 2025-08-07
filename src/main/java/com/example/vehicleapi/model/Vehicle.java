package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "vehicle")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String vin;
    private String make;
    private String model;
    @Column(name = "vehicle_year")
    private Integer year;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleCondition> vehicle_conditionList;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleStatus> vehicleStatuses;
    @OneToMany(mappedBy = "vehicle")
    private List<VehicleMetadata> vehicleMetadata;
}