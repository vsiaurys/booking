package com.example.booking.repositories;

import com.example.booking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findById(long id);

    Location findByName(String name);

    boolean existsByName(String name);
}