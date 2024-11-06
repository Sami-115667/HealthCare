package com.example.healthcare.healthcare.signuplogin;


import org.springframework.stereotype.Service;

import java.util.List;



public interface UserService {

    public String registerUser(UserDto userDto);
    public String registerAllUser(List<UserDto> list);
    public List<UserDto>  findalluser();
    public UserDto  findallfuserbyId(String Id);
    public String  updateUser(UserDto userDto,String Id);
    public String  deleteUser(String Id);


}
