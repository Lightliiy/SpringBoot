package com.example.MyApp.Repository;

import com.example.MyApp.Model.Booking;
import com.example.MyApp.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepo extends JpaRepository<Booking, Long> {

    List<Booking> findByUserEmail(String email); // Define the method to find bookings by user email
}
