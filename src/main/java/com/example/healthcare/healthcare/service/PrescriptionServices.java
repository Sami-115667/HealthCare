package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.PrescriptionEntity;
import com.example.healthcare.healthcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PrescriptionServices implements PrescriptionService{

    @Autowired
    PrescriptionRepository prescriptionRepository;

    public void savePrescription(PrescriptionEntity prescription) {
        // Set the issued date to the current date before saving
        //prescription.setIssuedDate(java.time.LocalDate.now());
        prescriptionRepository.save(prescription);
    }

    @Override
    public String prescription(PrescriptionEntity prescriptionEntity) {
        return null;
    }
}
