package com.example.booking.services;

import com.example.booking.models.Booking;
import com.example.booking.models.User;
import com.example.booking.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveBooking(Booking booking) {
        return this.bookingRepository.save(booking);
    }

    public Optional<Booking> findBookingByUser(User user) {
        return bookingRepository.findByUser(user);
    }

    public Booking findBookingById(long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }
}