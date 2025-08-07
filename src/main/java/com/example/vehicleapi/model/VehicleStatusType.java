package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle_status_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class VehicleStatusType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;

    @Schema(description = "TODO", example = "sample")
    private String code;

    @Schema(description = "TODO", example = "Standard vehicle processing workflow")
    private String description;

    @OneToMany(
            mappedBy = "statusType",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @Singular("vehicleStatus")
    private List<VehicleStatus> vehicleStatusList = new ArrayList<>();
}