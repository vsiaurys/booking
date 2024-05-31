package com.example.booking.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HotelLocationId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "Location_id")
    private Location location;

    @Autowired
    public HotelLocationId(Hotel hotel, Location location) {
        this.hotel = hotel;
        this.location = location;
    }

    public HotelLocationId() {}

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotelLocationId that = (HotelLocationId) o;

        return Objects.equals(hotel, that.hotel) && Objects.equals(location, that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotel, location);
    }
}