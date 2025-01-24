package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    List<BookingEntity> findByDoctorId(String doctor_id);
    List<BookingEntity> findByPatientId(String patient_id);

    BookingEntity findByDoctorIdAndAppointmentDate(String doctorId, LocalDate appointmentDate);

    @Query("SELECT COUNT(b) FROM BookingEntity b WHERE b.appointmentDate = :appointmentDate AND b.doctorId = :doctorId")
    long countBookingsByDateAndDoctor(@Param("appointmentDate") LocalDate appointmentDate, @Param("doctorId") Long doctorId);

}
