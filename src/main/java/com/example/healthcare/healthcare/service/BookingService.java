package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    //String bookingDoctor(BookingEntity bookingEntity);
    public void bookDoctor(String doctorId, String patientId, String patientName, LocalDate appointmentDate,String status);
    public List<BookingEntity> getBookingsByDoctorId(String doctorId);
    public List<BookingEntity> getBookingsByPatientId(String patientId);

    public List<BookingEntity> getbyidanddate(String doctorId, LocalDate appointmentDate);
}
