package com.example.booking.controllers;

import com.example.booking.models.Hotel;
import com.example.booking.models.HotelLocation;
import com.example.booking.models.HotelLocationId;
import com.example.booking.models.Location;
import com.example.booking.services.HotelLocationService;
import com.example.booking.services.HotelService;
import com.example.booking.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //    @GetMapping("/directorsmovies")
    //    public List<DirectorMovie> getDirectorsMovies() {
    //        return this.directorMovieService.findAllDirectorsMovies();
    //    }
    //
    //    @GetMapping("/directors/{directorId}/movies/{movieId}")
    //    public DirectorMovie getDirectorMovie(@PathVariable("directorId") long directorId, @PathVariable("movieId")
    // long movieId) {
    //        Director director = this.directorService.findDirectorById(directorId);
    //        Movie movie = this.movieService.findMovieById(movieId);
    //        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);
    //
    //        return this.directorMovieService.findDirectorMovieById(directorMovieId);
    //    }
    //
    @PostMapping("/hotelslocations")
    public HotelLocation insertHotelLocation() {
        HotelLocation hotelLocation = new HotelLocation(
                new HotelLocationId(new Hotel("Holiday Inn", "img/img.jpg"), new Location("Pagegiai")));
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        return this.hotelLocationService.saveHotelLocation(hotelLocation);
    }
}
