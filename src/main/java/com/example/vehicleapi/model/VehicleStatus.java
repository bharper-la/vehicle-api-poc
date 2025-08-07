package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate statusDate;
    private String notes;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "vehicle_status_type_id")
    private VehicleStatusType statusType;
}