package com.codeclan.example.courseBookingSystem.controllers;

import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/customers")
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name="courseName", required=false) String courseName,
            @RequestParam(name="town", required=false) String town,
            @RequestParam(name="age", required=false) Integer age
            ){
        if (age != null && town != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findByAgeGreaterThanAndTownAndBookingsCourseName(age, town, courseName), HttpStatus.OK);
        }
        if (town != null && courseName != null){
            return new ResponseEntity<>(customerRepository.findByTownAndBookingsCourseName(town, courseName),HttpStatus.OK);
        }
        if (courseName != null){
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id){
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
}
