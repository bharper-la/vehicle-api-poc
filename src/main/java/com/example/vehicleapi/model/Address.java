package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String line1;
    private String line2;
    private String city;
    private String state;
    private String postalCode;
    @OneToMany(mappedBy = "address")
    @Singular("user")
    private List<User> userList;
}