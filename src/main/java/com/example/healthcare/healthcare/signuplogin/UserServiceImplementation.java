package com.example.healthcare.healthcare.signuplogin;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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
        Optional<UserEntity> eoptional= userRepository.findById(Id);
        UserEntity convertValue = mapper.convertValue(userDto,UserEntity.class);
        convertValue.setId(Long.valueOf(Id));
        userRepository.save(convertValue);
        return "User Information Updated";
    }

    @Override
    public String deleteUser(String Id) {
        ObjectMapper mapper=new ObjectMapper();

        userRepository.deleteById(Id);
        return "User Deleted";
    }
}
