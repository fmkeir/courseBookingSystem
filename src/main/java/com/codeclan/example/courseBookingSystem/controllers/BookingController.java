package com.codeclan.example.courseBookingSystem.controllers;

import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping(value="/bookings")
public class BookingController {
    @Autowired
    BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(@RequestParam(name="date", required=false) String date){
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findByDate(date), HttpStatus.OK);
        }
        return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id){
        return new ResponseEntity(bookingRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking){
        bookingRepository.save(booking);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}
