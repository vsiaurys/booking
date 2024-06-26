package com.example.booking.controllers;

import com.example.booking.models.Hotel;
import com.example.booking.models.HotelLocation;
import com.example.booking.models.HotelLocationId;
import com.example.booking.models.Location;
import com.example.booking.services.HotelLocationService;
import com.example.booking.services.HotelService;
import com.example.booking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HotelLocationController {
    @Autowired
    private final HotelLocationService hotelLocationService;

    private final HotelService hotelService;
    private final LocationService locationService;

    @Autowired
    public HotelLocationController(
            HotelLocationService hotelLocationService, HotelService hotelService, LocationService locationService) {
        this.hotelLocationService = hotelLocationService;
        this.hotelService = hotelService;
        this.locationService = locationService;
    }

    @GetMapping("/hotels/{hotelId}/locations/{locationId}")
    public ResponseEntity<Object> getHotelLocation(
            @PathVariable("hotelId") long hotelId, @PathVariable("locationId") long locationId) {
        Map<String, String> errors = new HashMap<>();

        Hotel hotel = this.hotelService.findHotelById(hotelId);
        Location location = this.locationService.findLocationById(locationId);

        if (hotel == null && location == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
            errors.put("location", "Location with Id " + locationId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (hotel == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (location == null) {
            errors.put("location", "Location with Id " + locationId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        HotelLocationId hotelLocationId = new HotelLocationId(hotel, location);

        return ResponseEntity.ok(this.hotelLocationService.findHotelLocationById(hotelLocationId));
    }

    @PostMapping("/hotelslocations")
    public ResponseEntity<Object> insertHotelLocation(@RequestBody HotelLocation hotelLocation) {
        Map<String, String> errors = new HashMap<>();

        long hotelId = hotelLocation.getHotelLocationId().getHotel().getId();
        long locationId = hotelLocation.getHotelLocationId().getLocation().getId();

        Hotel hotel = this.hotelService.findHotelById(hotelId);
        Location location = this.locationService.findLocationById(locationId);

        if (hotel == null && location == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
            errors.put("location", "Location with Id " + locationId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (hotel == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (location == null) {
            errors.put("location", "Location with Id " + locationId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        String hotelName = hotelService.findHotelById(hotelId).getName();
        String locationName = locationService.findLocationById(locationId).getName();

        if (hotelLocationService.existsHotelLocationById(hotelLocation.getHotelLocationId())) {
            errors.put("hotelLocationId", "Hotel " + hotelName + " in " + locationName + " already exists");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        String hotelPicture = hotelService
                .findHotelById(hotelLocation.getHotelLocationId().getHotel().getId())
                .getPicture();

        hotelLocation.getHotelLocationId().getHotel().setName(hotelName);
        hotelLocation.getHotelLocationId().getHotel().setPicture(hotelPicture);
        hotelLocation.getHotelLocationId().getLocation().setName(locationName);

        return ResponseEntity.ok(this.hotelLocationService.saveHotelLocation(hotelLocation));
    }

    @GetMapping("/hotelslocations")
    public ResponseEntity<?> getAllHotelsLocations() {
        List<HotelLocation> listOfHotelsLocations = hotelLocationService.findAllHotelsLocations();

        if (listOfHotelsLocations == null || listOfHotelsLocations.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("hotelLocationId", "There are no hotels assigned to any location.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(listOfHotelsLocations);
    }
}