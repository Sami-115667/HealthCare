package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.Schedule;
import com.example.healthcare.healthcare.signuplogin.UserDto;

import java.util.List;

public interface DoctorService {
    List<UserDto> findalldoctor();

    List<UserDto> searchByCategory(String expertise);

    List<UserDto> searchByname(String name);



    String updateDoctorInformation(String id, DoctorEntity doctorEntity, Schedule schedule);
}
