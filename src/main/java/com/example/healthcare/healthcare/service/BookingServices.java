package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.List;

@Service
public class BookingServices implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public String bookingDoctor(BookingEntity bookingEntity) {

        Long doctorId = Long.parseLong(bookingEntity.getDoctorId());
        // Count the total bookings for the given date and doctor
        long totalBookings = bookingRepository.countBookingsByDateAndDoctor(bookingEntity.getAppointmentDate(), doctorId);

        // Check if slots are available
        if (totalBookings < bookingEntity.getTotalSlot()) {
            bookingRepository.save(bookingEntity);
            return "Booking Doctor Successfully";
        } else {
            return "No slots available for this date and doctor.";
        }
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
