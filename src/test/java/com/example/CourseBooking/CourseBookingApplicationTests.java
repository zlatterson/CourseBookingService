package com.example.CourseBooking;

import com.example.CourseBooking.models.Course;
import com.example.CourseBooking.models.Customer;
import com.example.CourseBooking.repositories.CourseRepository;
import com.example.CourseBooking.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseBookingApplicationTests {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Test
	void contextLoads() {
	}
	@Test
	void getCustomerByCourseId(){
        List<Customer> customers = customerRepository.findCustomerByBookingsCourseId(1L);
		System.out.println(customers);
    }
	@Test
	void getCoursesByCustomerId(){
		List<Course> courses = courseRepository.findCourseByBookingsCustomerId(1L);
		System.out.println(courses);
	}
	@Test
	void shouldGetAllCustomersInAGivenTownForAGivenCourse(){
		List<Customer> customers = customerRepository.findCustomerByBookingsCourseIdAndTownIgnoreCase(1L,"Dundee");
		assertEquals(2,customers.size());
	}
	@Test
	void shouldGetAllCustomersOverACertainAgeInAGivenTownForAGivenCourse(){
		List<Customer> customers = customerRepository.findCustomerByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(1L,"Dundee",30);
		assertEquals(1, customers.size());
	}
	@Test
	void shouldCorrectlyHandleCaseInsensitiveRoutes(){
		List<Customer> customers = customerRepository.findCustomerByBookingsCourseIdAndTownIgnoreCaseAndAgeGreaterThan(1L,"dundee",20);
		assertEquals(2, customers.size());
	}


}
