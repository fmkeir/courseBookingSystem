package com.codeclan.example.courseBookingSystem.repositories;

import com.codeclan.example.courseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(int rating);

    List<Course> findByBookingsCustomerName(String customer);
}
