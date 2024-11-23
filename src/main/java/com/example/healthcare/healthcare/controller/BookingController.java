package com.example.healthcare.healthcare.controller;


import com.example.healthcare.healthcare.signuplogin.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/booking")
public class BookingController {

    @PostMapping(value = "/booking")
    public String registerUser(@RequestBody UserDto userDto){
        return null;
    }

}
