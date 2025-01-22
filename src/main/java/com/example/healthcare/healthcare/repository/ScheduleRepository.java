package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository <Schedule,Integer> {
    Optional<Schedule> findByDoctorId(Integer doctorId);
}
