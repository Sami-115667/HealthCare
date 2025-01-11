package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity,Integer> {

}
