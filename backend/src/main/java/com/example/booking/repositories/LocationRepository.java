package com.example.booking.repositories;

import com.example.booking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findById(long id);

    Location findByName(String name);

    boolean existsByName(String name);
}