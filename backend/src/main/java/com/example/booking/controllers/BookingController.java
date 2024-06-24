package com.example.booking.controllers;

import com.example.booking.models.Booking;
import com.example.booking.models.Hotel;
import com.example.booking.models.User;
import com.example.booking.services.BookingService;
import com.example.booking.services.HotelService;
import com.example.booking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/bookings")
    public ResponseEntity<Object> insertBooking(@RequestBody Booking booking) {
        Map<String, String> errors = new HashMap<>();

        long hotelId = booking.getHotel().getId();
        long userId = booking.getUser().getId();

        Hotel hotel = this.hotelService.findHotelById(hotelId);
        User user = this.userService.findUserById(userId);

        if (hotel == null && user == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");
            errors.put("user", "User with Id " + userId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (hotel == null) {
            errors.put("hotel", "Hotel with Id " + hotelId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        if (user == null) {
            errors.put("user", "User with Id " + userId + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        return ResponseEntity.ok(this.bookingService.saveBooking(booking));
    }

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

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Object> getBooking(@PathVariable long id) {
        Booking booking = this.bookingService.findBookingById(id);

        if (booking == null) {
            Map<String, String> errors = new HashMap<>();
            errors.put("booking", "Booking with Id " + id + " does not exist");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        }

        return ResponseEntity.ok(booking);
    }
}
