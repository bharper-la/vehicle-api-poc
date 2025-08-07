package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "vehicle_condition_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleConditionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    @OneToMany(mappedBy = "vehicle_condition_type")
    private List<VehicleCondition> vehicle_conditionList;
}