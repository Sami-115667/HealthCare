package com.example.healthcare.healthcare.service;

import com.example.healthcare.healthcare.jwt.JwtService;
import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.repository.DoctorRepository;
import com.example.healthcare.healthcare.repository.UserRepository;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.sql.results.DomainResultCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImplementation implements UserService {


    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtService jwtService;


    @Override
    public String registerUser(UserDto userDto) {
        // Convert UserDto to UserEntity
        ObjectMapper mapper = new ObjectMapper();
        UserEntity convertValue = mapper.convertValue(userDto, UserEntity.class);
        userRepository.save(convertValue);

        if ("doctor".equals(convertValue.getRole())) {
            // Create a new DoctorEntity for the doctor role
            DoctorEntity doctorEntity = new DoctorEntity();
            doctorEntity.setId(convertValue.getId());  // Set the same ID from UserEntity

            // Save the doctor in the doctor table
            doctorRepository.save(doctorEntity);
        }

        return "Registration Successfully";
    }


    public UserEntity myProfile(String username) {
        ObjectMapper mapper = new ObjectMapper();

        // Fetch user entity by username
        UserEntity user = userRepository.findByUsername(username);
        System.out.println(user);

        return user;
    }



    @Override
    public String registerAllUser(List<UserDto> list) {
        return null;
    }

    @Override
    public List<UserDto> findalluser() {

        ObjectMapper mapper=new ObjectMapper();
        List<UserEntity> all=userRepository.findAll();
        List<UserDto> users= Arrays.asList(mapper.convertValue(all,UserDto[].class));
        return users;
    }

    @Override
    public UserDto findallfuserbyId(String Id) {
        return null;
    }

    @Override
    public String updateUser(UserDto userDto, String Id) {
        ObjectMapper mapper=new ObjectMapper();
        Optional<UserEntity> eoptional= userRepository.findById(Integer.valueOf(Id));
        UserEntity convertValue = mapper.convertValue(userDto,UserEntity.class);
        convertValue.setId(Long.valueOf(Id));
        userRepository.save(convertValue);
        return "User Information Updated";
    }

    @Override
    public String deleteUser(String Id) {
        ObjectMapper mapper=new ObjectMapper();

        userRepository.deleteById(Integer.valueOf(Id));
        return "User Deleted";
    }



    @Override
    public String verify(UserEntity user) {
        Authentication authentication=
                authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "failed";
    }
}
