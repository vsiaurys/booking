package com.example.booking.repositories;

import com.example.booking.models.Booking;
import com.example.booking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking findById(long id);

    Optional<Booking> findByUser(User user);
}