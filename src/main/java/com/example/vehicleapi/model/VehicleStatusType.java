package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
            mappedBy = "statusType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Singular("vehicleStatus")
    private List<VehicleStatus> vehicleStatusList = new ArrayList<>();
}
