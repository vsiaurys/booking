package com.example.booking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Hotel name cannot be empty")
    @Size(min = 2, message = "The entered hotel name must be at least 2 characters long")
    private String name;

    @Size(max = 255, message = "Hotel image URL must be less than 255 characters")
    // @URL(message = "Invalid hotel image URL")
    private String picture;

    public Hotel(String name, String picture) {
        this.name = name;

        this.picture = picture;
    }

    public Hotel() {}

    public void setName(String name) {
        this.name = name;
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

    public String getPicture() {
        return picture;
    }
}
