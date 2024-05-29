package com.example.booking.controllers;

import com.example.booking.models.Hotel;
import com.example.booking.models.Location;
import com.example.booking.services.HotelService;
import com.example.booking.services.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HotelController {
    private final HotelService hotelService;
    private final LocationService locationService;

    public HotelController(HotelService hotelService, LocationService locationService) {
        this.hotelService = hotelService;
        this.locationService = locationService;
    }

    @PostMapping("/hotel")
    public ResponseEntity<Object> addHotel(@RequestBody Hotel hotel) {
        Map<String, String> errors = new HashMap<>();

        //        if (hotelService.existsHotelByLocation(hotel.getName(), hotel)) {
        //            errors.put("name", "Hotel " + hotel.getName() + " already exists");
        //
        //            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
        //        }

        //        String n = hotel.getLocation().getName();
        //
        //        Optional<Location> l = locationService.findLocationByName(n);
        //        hotel.setLocation(l.getId());
        //
        //        // Hotel savedHotel =
        //        this.hotelService.saveHotel(hotel);
        //
        //        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);

        //        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
        //                .path("/{id}").buildAndExpand(savedReview.getId()).toUri()).body(savedReview);
        //
        //        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
        //                        .path("/{id}")
        //                        .buildAndExpand(hotel.getId())
        //                        .toUri())
        //                .body(this.hotelService.saveHotel(hotel));
        //    }
        // }

        Location location = hotel.getLocation();

        if (locationService.existsLocationByName(location.getName())) {

            List<Hotel> hotelList = hotelService.findAllHotelsByName(hotel.getName());

            for (Hotel hotelFromList : hotelList) {
                if (hotelFromList.getLocation().getName().equals(location.getName())) {
                    errors.put("name", "Hotel " + hotel.getName() + " in " + location.getName() + " already exists");

                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
                }
            }

            hotel.setLocation(locationService.findLocationByName(location.getName()));
            Hotel savedHotel = this.hotelService.saveHotel(hotel);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedHotel.getId())
                            .toUri())
                    .body(savedHotel);
        } else {
            //  Location not exists:
            Location savedLocation = this.locationService.saveLocation(location);
            hotel.setLocation(savedLocation);
            Hotel savedHotel = this.hotelService.saveHotel(hotel);

            return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(savedHotel.getId())
                            .toUri())
                    .body(savedHotel);
        }
    }
 }