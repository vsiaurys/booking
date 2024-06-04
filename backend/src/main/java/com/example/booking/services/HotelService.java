package com.example.booking.services;

import com.example.booking.models.Hotel;
import com.example.booking.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel saveHotel(Hotel hotel) {
        return this.hotelRepository.save(hotel);
    }

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel findHotelById(long id) {
        return hotelRepository.findById(id);
    }

    public Hotel findHotelByName(String name) {
        return hotelRepository.findByName(name);
    }

    public boolean existsHotelByName(String name) {
        return hotelRepository.existsByName(name);
    }
}
