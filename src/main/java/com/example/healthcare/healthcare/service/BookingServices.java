package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServices implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public String bookingDoctor(BookingEntity bookingEntity) {
        bookingRepository.save(bookingEntity);
        return "Booking Doctor Successfully";
    }



    public List<BookingEntity> getBookingsByDoctorId(String doctorId) {
        // Call the repository to fetch bookings for a particular doctor
        return bookingRepository.findByDoctorId(doctorId);
    }

    public List<BookingEntity> getBookingsByPatientId(String patientId) {
        // Call the repository to fetch bookings for a particular doctor
        return bookingRepository.findByPatientId(patientId);
    }



}
