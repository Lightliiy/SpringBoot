package com.example.MyApp.Controller;

import com.example.MyApp.Model.Booking;
import com.example.MyApp.Services.BookingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://localhost:3000") // Adjust origins as per your React frontend URL
public class BookingController {

    private final BookingServices bookingServices;

    @Autowired
    public BookingController(BookingServices bookingServices) {
        this.bookingServices = bookingServices;
    }

    @PostMapping("/add")
    public Booking createBooking(@RequestBody Booking booking) {
        System.out.println("Received booking data: " + booking.toString()); // Check if data is received correctly
        return bookingServices.saveBooking(booking);
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        try {
            return bookingServices.getAllBookings();
        } catch (Exception e) {
            System.err.println("Error fetching all bookings: " + e.getMessage());
            throw new RuntimeException("Failed to fetch bookings");
        }
    }

    @DeleteMapping("/cancel/{id}")
    public void cancelBooking(@PathVariable Long id) {
        try {
            bookingServices.cancelBooking(id);
        } catch (Exception e) {
            System.err.println("Error canceling booking with id " + id + ": " + e.getMessage());
            throw new RuntimeException("Failed to cancel booking");
        }
    }

//    @GetMapping("/user")
//    public List<Booking> getBookingsByUserEmail(Authentication authentication) {
//        String email = authentication.getName();
//        return bookingServices.getBookingsByUserEmail(email);
//    }
}
