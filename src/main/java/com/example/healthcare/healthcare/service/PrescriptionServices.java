package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;
import com.example.healthcare.healthcare.repository.BookingRepository;
import com.example.healthcare.healthcare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class PrescriptionServices implements PrescriptionService{

    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    BookingRepository bookingRepository;

    public void savePrescription(PrescriptionEntity prescription) {
        // Set the issued date to the current date before saving
        //prescription.setIssuedDate(java.time.LocalDate.now());

        // Save the prescription


        // Retrieve the BookingEntity for the given patient and appointment date
        BookingEntity entity = bookingRepository
                .findByDoctorIdAndAppointmentDate(prescription.getDoctorId(), prescription.getIssuedDate());
        System.out.println(entity);




        if (entity != null) {
            // Retrieve the list of patient data
            List<Map<String, Object>> data = entity.getData();

            // Iterate through the data to find the patient and update the status
            for (Map<String, Object> patientData : data) {
                if (patientData.containsKey("patientId") && patientData.get("patientId").equals(prescription.getPatientId())) {
                    // Update the patient's status to "Completed" (or any status you need)
                    if (patientData.containsKey("status") && !"Completed".equals(patientData.get("status"))) {
                        patientData.put("status", "Completed");
                    }


                    // Save the updated BookingEntity
                    bookingRepository.save(entity);
                    prescriptionRepository.save(prescription);
                    break;
                }
            }
        } else {
            // Handle case when the booking is not found (optional)
            throw new RuntimeException("Booking not found for the patient on the given date.");
        }
    }


    public List<PrescriptionEntity> getPrescriptionByPatientId(String patientId) {
        // Call the repository to fetch bookings for a particular doctor
        return prescriptionRepository.findBypatientId(patientId);
    }
}
