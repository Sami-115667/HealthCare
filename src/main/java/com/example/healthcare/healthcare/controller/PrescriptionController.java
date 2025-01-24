package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;
import com.example.healthcare.healthcare.service.BookingService;
import com.example.healthcare.healthcare.service.PrescriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/doctor")
public class PrescriptionController {

    @Autowired
    PrescriptionServices service;

    @PostMapping(value = "/prescription")
    public ResponseEntity<String> createPrescription(@RequestBody PrescriptionEntity prescription) {
        try {
            // Save the prescription via the service
            service.savePrescription(prescription);
            return ResponseEntity.status(HttpStatus.CREATED).body("Prescription created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating prescription: " + e.getMessage());
        }
    }


}
