package com.codeclan.example.courseBookingSystem.controllers;

import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping(value="/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name = "rating", required = false) Integer rating,
            @RequestParam(name = "customerName", required = false) String customerName
    ){
        if (rating != null) {
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        if (customerName != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Booking> createCourse(@RequestBody Course course){
        courseRepository.save(course);
        return new ResponseEntity(course, HttpStatus.CREATED);
    }
}
