package com.example.healthcare.healthcare.signuplogin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {


    @Autowired
    UserService service;


    @PostMapping(value = "/signup")
    public String registerUser(@RequestBody UserDto userDto){
        String signup =service.registerUser(userDto);
        return signup;
    }



    @PostMapping(value = "/login")
    public String loginUser(){

        return null;
    }




    @GetMapping(value = "/find")
    public String findUser(){

        return null;
    }




    @PutMapping(value = "/update")
    public String updateUser(){

        return null;
    }


    @DeleteMapping(value = "/delete")
    public String deleteUser(){

        return null;
    }
}
