package com.example.booking.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "Bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "User_id")
    @NotNull(message = "User cannot be null")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Hotel_id")
    @NotNull(message = "Hotel cannot be null")
    private Hotel hotel;

    @NotNull(message = "Start date of a booking cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "End date of a booking cannot be empty")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @NotEmpty(message = "Room type cannot be empty")
    @Pattern(regexp = "^(Standard|Deluxe|Suite)$", message = "Room type must be Standard, Deluxe or Suite")
    private String roomType;

    @NotNull(message = "Breakfast cannot be empty")
    private boolean breakfast;

    @Size(max = 255, message = "Comment must be less than 255 characters")
    private String comment;

    public Booking(
            User user,
            Hotel hotel,
            LocalDate startDate,
            LocalDate endDate,
            String roomType,
            boolean breakfast,
            String comment) {

        this.user = user;
        this.hotel = hotel;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomType = roomType;
        this.breakfast = breakfast;
        this.comment = comment;
    }

    public Booking() {}

    public void setUser(User user) {
        this.user = user;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public String getComment() {
        return comment;
    }
}
