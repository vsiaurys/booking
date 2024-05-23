package com.example.booking.services;

import com.example.booking.models.Location;
import com.example.booking.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location saveLocation(Location location) {
        return this.locationRepository.save(location);
    }

    public boolean existsLocationByName(String name) {
        return locationRepository.existsByName(name);
    }

    public Optional<Location> findLocationByName(String name) {
        return locationRepository.findByName(name);
    }

    public Optional<Location> findLocationById(long id) {
        return locationRepository.findById(id);
    }
}
