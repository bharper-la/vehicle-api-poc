package com.example.vehicleapi.repository;

import com.example.vehicleapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
