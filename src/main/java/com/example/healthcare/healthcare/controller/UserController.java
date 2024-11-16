package com.example.healthcare.healthcare.controller;


//import com.example.healthcare.healthcare.jwt.JwtMethods;
import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.signuplogin.UserDto;
import com.example.healthcare.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {


    @Autowired
    UserService service;


    @PostMapping(value = "/signup")
    public String registerUser(@RequestBody UserDto userDto){
        return service.registerUser(userDto);
    }





    @PostMapping(value = "/login")
    public String loginUser(@RequestBody UserEntity user) {
        System.out.println(user);
        return service.verify(user);
    }





    @GetMapping(value = "/find")
    public List<UserDto> findUser(){

        List<UserDto> allUser=service.findalluser();
        return allUser;
    }




    @PutMapping(value = "/update/{id}")
    public String updateUser(@RequestBody UserDto dto,@PathVariable String id){
        return service.updateUser(dto,id);
    }


    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@RequestBody UserDto dto,@PathVariable String id){
        return service.deleteUser(id);
    }
}