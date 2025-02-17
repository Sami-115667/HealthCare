package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Integer> {
    Optional<DoctorEntity> findByDoctorId(Integer doctorId);
    //DoctorEntity findById(String doctorId);
    
}
