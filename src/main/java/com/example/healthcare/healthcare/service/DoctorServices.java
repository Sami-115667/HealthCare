package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.repository.UserRepository;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DoctorServices implements DoctorService {


    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> findalldoctor() {

        ObjectMapper mapper=new ObjectMapper();
        List<UserEntity> allDoctors = userRepository.findByRole("doctor");
        List<UserDto> doctors= Arrays.asList(mapper.convertValue(allDoctors,UserDto[].class));
        return doctors;
    }

}
