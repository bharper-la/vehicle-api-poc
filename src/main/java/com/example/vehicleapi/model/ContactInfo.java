package com.example.vehicleapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "contact_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String phoneAreaCode;
    private String phoneExchangeNumber;
    private String phoneUnitNumber;
    private String phoneExtension;
    @OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<User> userList;
    @OneToMany(mappedBy = "contactInfo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lead> leadList = new ArrayList<>();
}