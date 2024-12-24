package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<BookingEntity,Integer> {

    List<BookingEntity> findByDoctorId(String doctor_id);
    List<BookingEntity> findByPatientId(String patient_id);

}
