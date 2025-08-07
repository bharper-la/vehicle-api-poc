package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String password;
    private Boolean enabled;
    private LocalDateTime createdAt;
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