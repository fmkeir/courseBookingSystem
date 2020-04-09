package com.codeclan.example.courseBookingSystem.components;

import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    
    @Autowired
    BookingRepository bookingRepository;
    
    @Autowired
    CourseRepository courseRepository;
    
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("Java", "Edinburgh", 5);
        courseRepository.save(course1);        
        
        Course course2 = new Course("Python", "Glasgow", 3);
        courseRepository.save(course2);        
        
        Course course3 = new Course("JavaScript", "Dundee", 4);
        courseRepository.save(course3);        
        
        Course course4 = new Course("Ruby", "Newcastle", 5);
        courseRepository.save(course4);        
        
        Course course5 = new Course("Go", "Leeds", 2);
        courseRepository.save(course5);        
        
        Course course6 = new Course("Pascal", "York", 2);
        courseRepository.save(course6);
        
        Customer fred = new Customer("Fred", "Dundee", 23);
        customerRepository.save(fred);
        
        Customer george = new Customer("George", "Manchester", 25);
        customerRepository.save(george); 
        
        Customer alan = new Customer("Alan", "Birmingham", 28);
        customerRepository.save(alan);  
        
        Customer hannah = new Customer("Hannah", "Carlisle", 31);
        customerRepository.save(hannah);    
        
        Customer april = new Customer("April", "Stoke", 19);
        customerRepository.save(april);   
        
        Customer jordan = new Customer("Jordan", "Haddington", 27);
        customerRepository.save(jordan);   
        
        Customer steven = new Customer("Steven", "Berwick", 34);
        customerRepository.save(steven); 
        
        Customer albert = new Customer("Albert", "Inverness", 29);
        customerRepository.save(albert);      
        
        Customer victoria = new Customer("Victoria", "Falkirk", 36);
        customerRepository.save(victoria);

        Booking booking1 = new Booking("12-01-19", course1, victoria);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("16-02-19", course2, victoria);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("30-04-20", course3, fred);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("20-04-20", course4, george);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking("21-06-21", course4, albert);
        bookingRepository.save(booking5);

        Booking booking6 = new Booking("01-07-22", course5, steven);
        bookingRepository.save(booking6);

        Booking booking7 = new Booking("05-08-18", course6, alan);
        bookingRepository.save(booking7);

        Booking booking8 = new Booking("28-09-17", course3, hannah);
        bookingRepository.save(booking8);

        Booking booking9 = new Booking("23-02-18", course2, april);
        bookingRepository.save(booking9);

        Booking booking10 = new Booking("21-01-19", course6, jordan);
        bookingRepository.save(booking10);
    }
}
