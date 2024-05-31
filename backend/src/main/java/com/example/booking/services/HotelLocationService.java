package com.example.booking.services;

import com.example.booking.models.HotelLocation;
import com.example.booking.models.HotelLocationId;
import com.example.booking.repositories.HotelLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelLocationService {
    private final HotelLocationRepository hotelLocationRepository;

    @Autowired
    public HotelLocationService(HotelLocationRepository hotelLocationRepository) {
        this.hotelLocationRepository = hotelLocationRepository;
    }

    public List<HotelLocation> findAllHotelsLocations() {
        return hotelLocationRepository.findAll();
    }

    public HotelLocation findHotelLocationById(HotelLocationId hotelLocationId) {
        return hotelLocationRepository.findById(hotelLocationId).orElseThrow();
    }

    public HotelLocation saveHotelLocation(HotelLocation hotelLocation) {
        return this.hotelLocationRepository.save(hotelLocation);
    }

    public boolean existsHotelLocationById(HotelLocationId hotelLocationId) {
        return this.hotelLocationRepository.existsById(hotelLocationId);
    }

    public void deleteHotelLocationById(HotelLocationId hotelLocationId) {
        this.hotelLocationRepository.deleteById(hotelLocationId);
    }
}