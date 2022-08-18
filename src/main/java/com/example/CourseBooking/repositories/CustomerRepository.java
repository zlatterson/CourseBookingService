package com.example.CourseBooking.repositories;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findCustomerByBookingsCourseId(Long id);
    List<Customer> findCustomerByBookingsCourseIdAndTown(Long id, String town);
    List<Customer> findCustomerByBookingsCourseIdAndTownAndAgeGreaterThan(Long id, String town, int age);
}
