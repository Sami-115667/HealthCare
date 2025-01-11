package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.PrescriptionEntity;
import com.example.healthcare.healthcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PrescriptionServices implements PrescriptionService{

    @Autowired
    PrescriptionRepository prescriptionRepository;

    @Override
    public String prescription(PrescriptionEntity prescriptionEntity) {
        prescriptionRepository.save(prescriptionEntity);
        return "Booking Doctor Successfully";
    }

}
