package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.model.BookingEntity;
import com.example.healthcare.healthcare.model.PrescriptionEntity;
import com.example.healthcare.healthcare.service.BookingService;
import com.example.healthcare.healthcare.service.PrescriptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
@RequestMapping(value = "/api/doctor")
public class PrescriptionController {

    @Autowired
    PrescriptionServices service;

    @PostMapping(value = "/prescription")
    public String bookDoctor(@RequestBody PrescriptionEntity prescriptionEntity){
        System.out.println(prescriptionEntity);
        return service.prescription(prescriptionEntity);
    }

}
