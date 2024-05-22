package com.example.booking.services;

import com.example.booking.models.Hotel;
import com.example.booking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    public boolean existsHotelByName(String name) {
        return hotelRepository.existsByName(name);
    }

    public Optional<Hotel> findHotelByName(String name) {
        return hotelRepository.findByName(name);
    }

    public Optional<Hotel> findHotelByLocation(String location) {
        return hotelRepository.findByLocation(location);
    }

    public Optional<Hotel> findHotelById(long id) {
        return hotelRepository.findById(id);
    }
}
