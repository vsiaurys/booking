package com.example.booking.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Hotels_Locations")
public class HotelLocation {
    @EmbeddedId
    private HotelLocationId hotelLocationId;

    public HotelLocation(HotelLocationId hotelLocationId) {
        this.hotelLocationId = hotelLocationId;
    }

    public void setHotelLocationId(HotelLocationId hotelLocationId) {
        this.hotelLocationId = hotelLocationId;
    }

    public HotelLocationId getHotelLocationId() {
        return hotelLocationId;
    }
}