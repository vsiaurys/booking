package com.example.booking.controllers;

import com.example.booking.models.Hotel;
import com.example.booking.models.HotelLocation;
import com.example.booking.models.HotelLocationId;
import com.example.booking.models.Location;
import com.example.booking.services.HotelLocationService;
import com.example.booking.services.HotelService;
import com.example.booking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public HotelLocation getHotelLocation(
            @PathVariable("hotelId") long hotelId, @PathVariable("locationId") long locationId) {

        Hotel hotel = this.hotelService.findHotelById(hotelId);
        Location location = this.locationService.findLocationById(locationId);
        HotelLocationId hotelLocationId = new HotelLocationId(hotel, location);

        return this.hotelLocationService.findHotelLocationById(hotelLocationId);
    }

    @PostMapping("/hotelslocations")
    public HotelLocation insertHotelLocation(@RequestBody HotelLocation hotelLocation) {
        return this.hotelLocationService.saveHotelLocation(hotelLocation);
    }

    @GetMapping("/hotelslocations")
    public List<HotelLocation> getAllHotelsLocations() {
        return hotelLocationService.findAllHotelsLocations();
    }
}