package com.example.booking.repositories;

import com.example.booking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findHotelByName(String name);

    Optional<Hotel> findHotelById(long id);

    boolean existsByName(String name);
}