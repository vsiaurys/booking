package com.example.booking.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Location cannot be empty")
    @Pattern.List({
        @Pattern(regexp = "[A-Z].*", message = "Location name must start out of a letter in uppercase"),
        @Pattern(regexp = "[A-Za-z]+", message = "Locations name may contain only letters"),
        @Pattern(regexp = "^(?!.*(.)\\1{4}).*$", message = "Same character cannot repeat 5 times or more")
    })
    private String name;

    public Location(String name) {
        this.name = name;
    }

    public Location() {}

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
