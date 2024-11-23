package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.service.DoctorService;
import com.example.healthcare.healthcare.service.DoctorServices;
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



}
