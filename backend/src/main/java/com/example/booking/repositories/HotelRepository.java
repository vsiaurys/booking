package com.example.booking.repositories;

import com.example.booking.models.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Hotel findByName(String name);

    Hotel findById(long id);

    boolean existsByName(String name);
}
