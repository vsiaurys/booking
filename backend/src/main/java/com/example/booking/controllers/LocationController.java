package com.example.booking.controllers;

import com.example.booking.models.Location;
import com.example.booking.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LocationController {
    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/locations")
    public ResponseEntity<Object> addLocation(@RequestBody Location location) {
        Map<String, String> errors = new HashMap<>();

        if (locationService.existsLocationByName(location.getName())) {
            errors.put("name", "Location " + location.getName() + " already exists");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Location savedLocation = this.locationService.saveLocation(location);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedLocation.getId())
                        .toUri())
                .body(savedLocation);
    }

    @GetMapping("/locations")
    public ResponseEntity<?> getAllLocations() {

        List<Location> listOfLocations = locationService.findAllLocations();

        if (listOfLocations == null || listOfLocations.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("location", "The list of locations is empty.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(listOfLocations);
    }

    @GetMapping("/locations/{id}")
    public ResponseEntity<Object> getLocation(@PathVariable long id) {
        Location location = this.locationService.findLocationById(id);

        if (location == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("location", "Location with Id " + id + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        return ResponseEntity.ok(location);
    }
}
