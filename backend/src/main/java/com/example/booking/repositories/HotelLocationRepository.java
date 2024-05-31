package com.example.booking.repositories;

import com.example.booking.models.HotelLocation;
import com.example.booking.models.HotelLocationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelLocationRepository extends JpaRepository<HotelLocation, HotelLocationId> {}
