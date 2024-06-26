package com.example.booking.controllers;

import com.example.booking.models.Hotel;
import com.example.booking.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/hotels")
    public ResponseEntity<Object> addHotel(@RequestBody Hotel hotel) {
        Map<String, String> errors = new HashMap<>();

        if (hotelService.existsHotelByName(hotel.getName())) {
            errors.put("name", "Hotel " + hotel.getName() + " already exists");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        Hotel savedHotel = this.hotelService.saveHotel(hotel);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(savedHotel.getId())
                        .toUri())
                .body(savedHotel);
    }

    @GetMapping("/hotels")
    public ResponseEntity<?> getAllHotels() {

        List<Hotel> listOfHotels = hotelService.findAllHotels();

        if (listOfHotels == null || listOfHotels.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("hotel", "The list of hotels is empty.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(listOfHotels);
    }

    @GetMapping("/hotels/{id}")
    public ResponseEntity<Object> getHotel(@PathVariable long id) {
        Hotel hotel = this.hotelService.findHotelById(id);

        if (hotel == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("hotel", "Hotel with Id " + id + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        return ResponseEntity.ok(hotel);
    }
 }