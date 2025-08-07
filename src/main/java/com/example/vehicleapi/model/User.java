package com.example.vehicleapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "TODO: Add description")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "TODO", example = "sample")
    private Integer id;
    @Schema(description = "TODO", example = "admin")
    private String login;
    @Schema(description = "TODO", example = "password")
    private String password;
    @Schema(description = "TODO", example = "true")
    private Boolean enabled;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime createdAt;
    @Schema(description = "TODO", example = "sample")
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name = "contact_info_id")
    private ContactInfo contactInfo;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "user")
    @Singular("auctionFilter")
    private List<AuctionFilter> auctionFilters;
    @OneToMany(mappedBy = "user")
    @Singular("auctionWatch")
    private List<AuctionWatch> auctionWatches;
}