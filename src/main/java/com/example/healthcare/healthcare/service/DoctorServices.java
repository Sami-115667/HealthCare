package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.repository.DoctorRepository;
import com.example.healthcare.healthcare.repository.UserRepository;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorServices implements DoctorService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public List<UserDto> findalldoctor() {

        ObjectMapper mapper=new ObjectMapper();
        List<UserEntity> allDoctors = userRepository.findByRole("doctor");
        List<UserDto> doctors= Arrays.asList(mapper.convertValue(allDoctors,UserDto[].class));
        return doctors;
    }


    @Override
    public List<UserDto> searchByCategory(String expertise) {

        ObjectMapper mapper=new ObjectMapper();
        List<UserEntity> allDoctors = userRepository.findByExpertise(expertise);
        List<UserDto> doctors= Arrays.asList(mapper.convertValue(allDoctors,UserDto[].class));
        return doctors;
    }

    @Override
    public List<UserDto> searchByname(String name) {

        ObjectMapper mapper=new ObjectMapper();
        List<UserEntity> allDoctors = userRepository.findByName(name);
        List<UserDto> doctors= Arrays.asList(mapper.convertValue(allDoctors,UserDto[].class));
        return doctors;
    }


    @Override
    public String updateDoctorInformation(String id, DoctorEntity doctorEntity) {

        // Convert the String 'id' to Long
        Long doctorId = Long.valueOf(id);

        // Find the doctor by ID
        Optional<DoctorEntity> optionalDoctor = doctorRepository.findById(Math.toIntExact(doctorId));

        if (optionalDoctor.isPresent()) {
            DoctorEntity existingDoctor = optionalDoctor.get();

            // Update the doctor fields with the new values from doctorEntity
            existingDoctor.setDescription(doctorEntity.getDescription());
            existingDoctor.setFees(doctorEntity.getFees());
            existingDoctor.setSchedule(doctorEntity.getSchedule());

            // Save the updated doctor information
            doctorRepository.save(existingDoctor);

            return "Doctor Information Updated Successfully";
        } else {
            return "Doctor not found";
        }
    }







}
