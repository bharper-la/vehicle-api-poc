package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle_condition")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleCondition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate conditionDate;
    private String comments;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    @ManyToOne
    @JoinColumn(name = "vehicle_condition_type_id")
    private VehicleConditionType conditionType;
}