package com.example.booking.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotels_Locations")
public class HotelsLocations {
    @EmbeddedId
    private HotelLocationId hotelLocationId;

    public HotelsLocations(HotelLocationId hotelLocationId) {
        this.hotelLocationId = hotelLocationId;
    }

    public void setHotelLocationId(HotelLocationId hotelLocationId) {
        this.hotelLocationId = hotelLocationId;
    }

    public HotelLocationId getHotelLocationId() {
        return hotelLocationId;
    }
}