package com.example.healthcare.healthcare.service;


import com.example.healthcare.healthcare.model.UserEntity;
import com.example.healthcare.healthcare.signuplogin.UserDto;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;



public interface UserService {

    public String registerUser(UserDto userDto);
    public String registerAllUser(List<UserDto> list);
    public List<UserDto>  findalluser();
    public UserDto  findallfuserbyId(String Id);
    public String  updateUser(UserDto userDto,String Id);
    public String  deleteUser(String Id);

//    UserDetails loadUserByname(String username) throws UsernameNotFoundException;

    String verify(UserEntity user);
}
