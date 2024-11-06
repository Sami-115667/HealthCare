package com.example.healthcare.healthcare.signuplogin;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;

    private String username,password,email,role,number,expertise,degree,image, schedule,credential,deskid;
    private boolean verified;

}
