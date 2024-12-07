package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Integer> {
    
}
