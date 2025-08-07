package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "vehicle_condition_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class VehicleConditionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "sample")
    private String code;
    @Schema(description = "TODO", example = "Standard vehicle processing workflow")
    private String description;
    @OneToMany(mappedBy = "conditionType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VehicleCondition> vehicle_conditionList;
}