package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByRating(int rating);
    List<Course> findCourseByBookingsCustomerId(Long id);

}
