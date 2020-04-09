package com.codeclan.example.courseBookingSystem;

import com.codeclan.example.courseBookingSystem.models.Booking;
import com.codeclan.example.courseBookingSystem.models.Course;
import com.codeclan.example.courseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.courseBookingSystem.models.Customer;
import com.codeclan.example.courseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.courseBookingSystem.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class CourseBookingSystemApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllCoursesRated5() {
		assertEquals(2, courseRepository.findByRating(5).size());
	}

	@Test
	public void canGetAllCustomersForCourse4(){
		assertEquals(2, customerRepository.findByBookingsCourseName("Ruby").size());
	}

	@Test
	public void canGetAllCoursesForCustomerVictoria(){
		assertEquals(2, courseRepository.findByBookingsCustomerName("Victoria").size());
	}

	@Test
	public void canGetAllBookingsFor120119() {
		assertEquals(1, bookingRepository.findByDate("12-01-19").size());
	}
}
