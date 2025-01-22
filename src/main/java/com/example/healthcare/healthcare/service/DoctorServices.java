package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.Schedule;
import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.repository.DoctorRepository;
import com.example.healthcare.healthcare.repository.ScheduleRepository;
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
    @Autowired
    ScheduleRepository scheduleRepository;

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
    public String updateDoctorInformation(String id, DoctorEntity doctorEntity, Schedule schedule) {

        int count=0;
        System.out.println(id);
        Optional<DoctorEntity> existingDoctorOptional= doctorRepository.findByDoctorId(Integer.valueOf(id));
        Optional<Schedule> existingDoctorOptional1= scheduleRepository.findByDoctorId(Integer.valueOf(id));
        System.out.println(doctorEntity.getDoctorId());

        // Fetch the doctor from the repository by ID
        //Optional<DoctorEntity> existingDoctorOptional = doctorRepository.findById(doctorId);

        // Check if the doctor exists
        if (existingDoctorOptional.isPresent()) {
            DoctorEntity existingDoctor = existingDoctorOptional.get();

            // Update fields if they are not null or valid
            if (doctorEntity.getDescription() != null) {
                existingDoctor.setDescription(doctorEntity.getDescription());
            }
            if (doctorEntity.getFees() > 0) {
                existingDoctor.setFees(doctorEntity.getFees());
            }

            // Save the updated doctor
            doctorRepository.save(existingDoctor);
            count++;

        }
        if (existingDoctorOptional.isPresent()) {
            Schedule existingDoctor1 = existingDoctorOptional1.get();

            // Update fields if they are not null or valid
            if (schedule.getSun() != null) {
                existingDoctor1.setSun(schedule.getSun());
            }
            if (schedule.getMon() != null) {
                existingDoctor1.setMon(schedule.getMon());
            }
            if (schedule.getTue() != null) {
                existingDoctor1.setTue(schedule.getTue());
            }
            if (schedule.getWed() != null) {
                existingDoctor1.setWed(schedule.getWed());
            }
            if (schedule.getThu() != null) {
                existingDoctor1.setThu(schedule.getThu());
            }
            if (schedule.getFri() != null) {
                existingDoctor1.setFri(schedule.getFri());
            }
            if (schedule.getSat() != null) {
                existingDoctor1.setSat(schedule.getSat());
            }



            // Save the updated doctor
            scheduleRepository.save(existingDoctor1);
            count++;

        }
        if(count==2)
            return "Successfully updated";
        else {
            return "Doctor not found."; // Return a message if the doctor is not found
        }

    }






}
