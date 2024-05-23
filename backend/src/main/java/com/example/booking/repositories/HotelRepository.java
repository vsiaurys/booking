package com.example.booking.repositories;

import com.example.booking.models.Hotel;
import com.example.booking.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String name);

    Optional<Hotel> findByLocation(Location location);

    Optional<Hotel> findById(long id);

    boolean existsByName(String name);
}