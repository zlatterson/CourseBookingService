package com.example.CourseBooking.controllers;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getCourses(
            @RequestParam(name = "rating", required = false) Integer rating
            ){
        if (rating != null){
            return new ResponseEntity<>(courseRepository.findByRating(rating), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/courses/{id}/customers")
    public ResponseEntity<List<Customer>> getCourseCustomers(
            @PathVariable Long id,
            @RequestParam(name = "town",required = false) String town,
            @RequestParam(name = "age",required = false) Integer age

    ){
        if(town != null){
            if(age != null){
                return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(id,town,age),HttpStatus.OK);
            }
            return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseIdAndTownIgnoreCase(id,town),HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseId(id),HttpStatus.OK);
    }
}
