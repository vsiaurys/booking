package com.example.booking.controllers;

import com.example.booking.models.Location;
import com.example.booking.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/location")
    public ResponseEntity<Object> addLocation(@RequestBody Location location) {
        Map<String, String> errors = new HashMap<>();

        if (locationService.existsLocationByName(location.getName())) {

            errors.put("location", "Location " + location.getName() + " already exists");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Location savedLocation = this.locationService.saveLocation(location);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedLocation.getId())
                        .toUri())
                .body(savedLocation);
    }
}
