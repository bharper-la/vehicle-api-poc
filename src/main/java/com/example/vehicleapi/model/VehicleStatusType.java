package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "vehicle_status_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleStatusType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    @OneToMany(mappedBy = "vehicle_status_type")
    private List<VehicleStatus> vehicle_statusList;
}