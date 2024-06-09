package com.example.booking.controllers;

import com.example.booking.models.Booking;
import com.example.booking.services.BookingService;
import com.example.booking.services.HotelService;
import com.example.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {
    private final BookingService bookingService;
    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService, HotelService hotelService) {
        this.bookingService = bookingService;
        this.userService = userService;
        this.hotelService = hotelService;
    }

    //    @GetMapping("/hotels/{hotelId}/locations/{locationId}")
    //    public ResponseEntity<Object> getHotelLocation(
    //            @PathVariable("hotelId") long hotelId, @PathVariable("locationId") long locationId) {
    //        Map<String, String> errors = new HashMap<>();
    //
    //        Hotel hotel = this.hotelService.findHotelById(hotelId);
    //        Location location = this.locationService.findLocationById(locationId);
    //
    //        if (hotel == null && location == null) {
    //            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
    //            errors.put("location", "Location with Id " + locationId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        if (hotel == null) {
    //            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        if (location == null) {
    //            errors.put("location", "Location with Id " + locationId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        HotelLocationId hotelLocationId = new HotelLocationId(hotel, location);
    //
    //        return ResponseEntity.ok(this.hotelLocationService.findHotelLocationById(hotelLocationId));
    //    }
    //
    //    @PostMapping("/hotelslocations")
    //    public ResponseEntity<Object> insertHotelLocation(@RequestBody HotelLocation hotelLocation) {
    //        Map<String, String> errors = new HashMap<>();
    //
    //        long hotelId = hotelLocation.getHotelLocationId().getHotel().getId();
    //        long locationId = hotelLocation.getHotelLocationId().getLocation().getId();
    //
    //        Hotel hotel = this.hotelService.findHotelById(hotelId);
    //        Location location = this.locationService.findLocationById(locationId);
    //
    //        if (hotel == null && location == null) {
    //            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
    //            errors.put("location", "Location with Id " + locationId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        if (hotel == null) {
    //            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        if (location == null) {
    //            errors.put("location", "Location with Id " + locationId + " does not exist");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        String hotelName = hotelService.findHotelById(hotelId).getName();
    //        String locationName = locationService.findLocationById(locationId).getName();
    //
    //        if (hotelLocationService.existsHotelLocationById(hotelLocation.getHotelLocationId())) {
    //            errors.put("hotelLocationId", "Hotel " + hotelName + " in " + locationName + " already exists");
    //
    //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    //        }
    //
    //        String hotelPicture = hotelService
    //                .findHotelById(hotelLocation.getHotelLocationId().getHotel().getId())
    //                .getPicture();
    //
    //        hotelLocation.getHotelLocationId().getHotel().setName(hotelName);
    //        hotelLocation.getHotelLocationId().getHotel().setPicture(hotelPicture);
    //        hotelLocation.getHotelLocationId().getLocation().setName(locationName);
    //
    //        return ResponseEntity.ok(this.hotelLocationService.saveHotelLocation(hotelLocation));
    //    }

    @GetMapping("/bookings")
    public ResponseEntity<?> getAllBookings() {
        List<Booking> listOfBookings = bookingService.findAllBookings();

        if (listOfBookings == null || listOfBookings.isEmpty()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("id", "The list of bookings is empty");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }
        return ResponseEntity.ok(listOfBookings);
    }
}
