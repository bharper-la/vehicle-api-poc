package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auction_filter_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuctionFilterType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filterType;

    private LocalDateTime createdAt;
}
