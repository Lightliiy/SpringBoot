package com.example.MyApp.Services;

import com.example.MyApp.Model.Booking;
import com.example.MyApp.Repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices {

    private final BookingRepo bookingRepo;

    @Autowired
    public BookingServices(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepo.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public void cancelBooking(Long id) {
        bookingRepo.deleteById(id);
    }

    public List<Booking> getBookingsByUserEmail(String email) {
        return bookingRepo.findByUserEmail(email);
    }
}
