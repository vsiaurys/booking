package com.example.booking.repositories;

import com.example.booking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    List<Hotel> findByName(String name);

    Optional<Hotel> findById(long id);

    boolean existsByName(String name);
}
