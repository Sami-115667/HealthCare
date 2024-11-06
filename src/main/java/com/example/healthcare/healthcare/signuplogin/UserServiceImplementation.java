package com.example.healthcare.healthcare.signuplogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImplementation implements UserService{


    @Autowired
    UserRepository userRepository;


    @Override
    public String registerUser(UserDto userDto) {
        ObjectMapper mapper=new ObjectMapper();
        UserEntity convertValue = mapper.convertValue(userDto,UserEntity.class);
        userRepository.save(convertValue);
        return "User Information Save";
    }

    @Override
    public String registerAllUser(List<UserDto> list) {
        return null;
    }

    @Override
    public List<UserDto> findalluser() {
        return null;
    }

    @Override
    public UserDto findallfuserbyId(String Id) {
        return null;
    }

    @Override
    public String updateUser(UserDto userDto, String Id) {
        return null;
    }

    @Override
    public String deleteUser(String Id) {
        return null;
    }
}
