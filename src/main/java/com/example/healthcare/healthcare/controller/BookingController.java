package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.service.BookingService;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/booking")
public class BookingController {

    @Autowired
    BookingService service;

    @PostMapping(value = "/booking")
    public String bookDoctor(@RequestBody BookingEntity bookingEntity){
        System.out.println(bookingEntity);
        return service.bookingDoctor(bookingEntity);
    }


    @GetMapping(value = "/doctorBookings")
    public List<BookingEntity> getBookingsByDoctorId(@RequestParam String doctorId) {
        // Fetch bookings only for the specific doctor
        return service.getBookingsByDoctorId(doctorId);  // Calling service method
    }

    @GetMapping(value = "/patientBookings")
    public List<BookingEntity> getBookingsByPatientId(@RequestParam String patientId) {
        // Fetch bookings only for the specific doctor
        return service.getBookingsByPatientId(patientId);  // Calling service method
    }



}
