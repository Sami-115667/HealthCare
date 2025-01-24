package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;

import java.util.List;

public interface PrescriptionService {

    public void savePrescription(PrescriptionEntity prescription);

    public List<PrescriptionEntity> getPrescriptionByPatientId(String patientId);
}
