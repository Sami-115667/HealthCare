package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;

import java.util.List;

public interface BookingService {

    String bookingDoctor(BookingEntity bookingEntity);
    public List<BookingEntity> getBookingsByDoctorId(String doctorId);
    public List<BookingEntity> getBookingsByPatientId(String patientId);
}
