package com.example.booking.repositories;

import com.example.booking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findByName(String name);

    Optional<Hotel> findByLocation(String location);

    Optional<Hotel> findById(long id);

    boolean existsByLocation(String location);
}