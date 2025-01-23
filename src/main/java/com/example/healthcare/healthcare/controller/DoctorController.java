package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.DoctorScheduleRequest;
import com.example.healthcare.healthcare.model.Schedule;
import com.example.healthcare.healthcare.repository.ScheduleRepository;
import com.example.healthcare.healthcare.service.DoctorService;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins= "http://localhost:3000")
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
    public String updateDoctor(@RequestParam(required = false) String doctorId, @RequestBody DoctorScheduleRequest doctorScheduleRequest) {

        DoctorEntity doctorEntity = doctorScheduleRequest.getDoctor();
        Schedule schedule = doctorScheduleRequest.getSchedule();
        return doctorServices.updateDoctorInformation(doctorId,doctorEntity,schedule);
    }



    @Autowired
    ScheduleRepository scheduleRepository;


    @GetMapping("/schedule/{id}")
    public Schedule getSchedule(@PathVariable("id") String id) {

        //Optional<DoctorEntity> existingDoctorOptional= doctorRepository.findByDoctorId(Integer.valueOf(id));
        Optional<Schedule> existingDoctorOptional1= scheduleRepository.findByDoctorId(Integer.valueOf(id));
        if (existingDoctorOptional1.isPresent()) {
            Schedule existingDoctor = existingDoctorOptional1.get();

            return existingDoctor;
        }

            // Use the 'id' variable in your logic

        return null;
    }




}
