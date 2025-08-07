package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class VehicleMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "inspection")
    private String type;
    @Schema(description = "TODO", example = "{\"status\":\"passed\", \"mileage\":12345}")
    private String data;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}