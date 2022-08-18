package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;
    @GetMapping(value = "/customers/{id}/courses")
    public ResponseEntity<List<Course>> getCustomerCourses(@PathVariable Long id){
        return new ResponseEntity<>(courseRepository.findCourseByBookingsCustomerId(id), HttpStatus.OK);
    }
}
