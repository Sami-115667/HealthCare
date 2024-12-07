package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.service.DoctorService;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorServices;

    @GetMapping(value = "/alldoctor")
    public List<UserDto> findUser(){

        List<UserDto> allDoctor=doctorServices.findalldoctor();
        return allDoctor;
    }


    @GetMapping(value = "/search")
    public List<UserDto> searchDoctors(
            @RequestParam(required = false) String expertise,
            @RequestParam(required = false) String name) {

        if (expertise != null && name != null) {
            throw new IllegalArgumentException("Please provide only one search parameter: either category or username, not both.");
        } else if (expertise != null) {
            return doctorServices.searchByCategory(expertise);
        } else if (name != null) {
            return doctorServices.searchByname(name);
        } else {
            throw new IllegalArgumentException("At least one search parameter (category or username) must be provided.");
        }
    }




    @PutMapping("/booking_doctor/{doctorId}")
    public String updateDoctor(@PathVariable String doctorId, @RequestBody DoctorEntity doctorEntity) {



        return doctorServices.updateDoctorInformation(doctorId,doctorEntity);
    }




}
