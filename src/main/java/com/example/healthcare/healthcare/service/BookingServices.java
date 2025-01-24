package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingServices implements BookingService{

    @Autowired
    BookingRepository bookingRepository;

    public int bookDoctor(String doctorId, String patientId, String patientName, LocalDate appointmentDate, String status) {
        // Check if a booking exists for the same doctor and appointment date
        BookingEntity existingBooking = bookingRepository
                .findByDoctorIdAndAppointmentDate(doctorId, appointmentDate);


        int serial=0;

        if (existingBooking != null) {
            // Booking already exists for this doctor and date, add patient data
            List<Map<String, Object>> data = existingBooking.getData();
            serial= data.size();
            Map<String, Object> patientData = new HashMap<>();
            patientData.put("patientId", patientId);
            patientData.put("patientName", patientName);
            patientData.put("status", status); // Can add actual time if needed

            data.add(patientData); // Add new patient to the existing list
            existingBooking.setData(data); // Update the data list in the entity

            bookingRepository.save(existingBooking); // Save updated entity
            return serial+1;

        } else {
            // If no existing booking, create a new booking
            BookingEntity newBooking = new BookingEntity();
            newBooking.setDoctorId(doctorId);
            newBooking.setAppointmentDate(appointmentDate);
            Map<String, Object> patientData = new HashMap<>();
            patientData.put("patientId", patientId);
            patientData.put("patientName", patientName);
            patientData.put("status", status); // Can add actual time if needed

            newBooking.setData(List.of(patientData)); // Store the patient data as a list

            bookingRepository.save(newBooking); // Save new booking
            return 1;
        }
    }


//    @Override
//    public String bookingDoctor(BookingEntity bookingEntity) {
//        return null;
//    }

    public List<BookingEntity> getBookingsByDoctorId(String doctorId) {
        // Call the repository to fetch bookings for a particular doctor
        return bookingRepository.findByDoctorId(doctorId);
    }

    public List<BookingEntity> getBookingsByPatientId(String patientId) {
        // Call the repository to fetch bookings for a particular doctor
        return bookingRepository.findByPatientIdInData(patientId);
    }

    public List<BookingEntity> getbyidanddate(String doctorId, LocalDate appointmentDate) {
        // Call the repository to fetch bookings for a particular doctor
        return bookingRepository.findByDoctorIdAndAppointmentDates(doctorId,appointmentDate);
    }



}
