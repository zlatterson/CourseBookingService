
# Booking System

Solo Lab Exercise to Practice a Course Booking backend with spring.


## Brief

## MVP

### Models
The course reservations API needs to be built with three models with the following properties:

* Course
  * name - the name of the course eg: Intro to Python
  * town - the town/city/village where the course is located. We will not bother with full address yet.
  * star rating - Out of 5, each course has a rating
* Booking
   * date - a **string** in the form "dd-mm-yy" for the booking date. Dates can be in the future or in the past

* Customer
   * name - **string** containing customer's name
   * town - a **string** containing the town where the customer lives. We will not record an address at this stage
   * age - the customers age. Useful for marketing purposes

The relationships should be:

* A Course has many Bookings
* A Booking has a Course
* A Customer has many bookings
* A booking has a customer

### Queries + Custom Routes

Write queries using the derived method we've shown. Connect these to suitable RESTful endpoints and decide whether you should use a filter or not for all of:

* Get all courses with a given rating
* Get all customers for a given course
* Get all courses for a given customer
* Get all bookings for a given date


## Extensions


### Extension Queries + Routes

* Get all customers in a given town for a given course
* Get all customers over a certain age in a given town for a given course

You need to write and test these queries.

### Other Extensions
* Correctly handle case-insensitive routes with Spring RestController or the `IgnoreCase` in derived queries.


## Planning

![Image of the class diagrams](https://i.imgur.com/M4wvZyX.png)

A Booking table would have a many to one relationship with a course and a customer.
## Testing
![Screenshot of tests passing](https://i.imgur.com/jnpI7mR.png)
Application was written with TDD.

### Insomnia

Insomnia was used to test the Spring routes

![Screenshot of Insomnia Test](https://i.imgur.com/pWW9tXg.png)
![Screenshot of Insomnia Test](https://i.imgur.com/7lnpYdd.png)
![Screenshot of Insomnia Test](https://i.imgur.com/WLIKVfj.png)
![Screenshot of Insomnia Test](https://i.imgur.com/j6ysW0m.png)
![Screenshot of Insomnia Test](https://i.imgur.com/N83hKcR.png)
## Outcomes

Solidified learning on writing custom query functions with spring.