package com.example.booking.repositories;

import com.example.booking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByName(String name);

    Optional<Location> findById(long id);

    boolean existsByName(String name);
}