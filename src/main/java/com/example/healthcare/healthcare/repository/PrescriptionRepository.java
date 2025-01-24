package com.example.healthcare.healthcare.repository;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity,Integer> {

    List<PrescriptionEntity> findBypatientId(String patientId);

}
