package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vehicle_metadata")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String data;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
}