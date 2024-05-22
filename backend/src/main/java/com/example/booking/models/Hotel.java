package com.example.booking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "Hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Hotel name cannot be empty")
    @Size(min = 2, message = "The entered hotel name seems to be too short")
    private String name;

    @NotEmpty(message = "Location cannot be empty")
    @Size(min = 5, message = "The entered location seems to be too short")
    private String location;

    @Size(max = 255, message = "Hotel image URL must be less than 255 characters")
    @URL(message = "Invalid hotel image URL")
    private String picture;

    public Hotel(long id, String name, String location, String picture) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.picture = picture;
    }

    public Hotel() {}

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPicture() {
        return picture;
    }
}
