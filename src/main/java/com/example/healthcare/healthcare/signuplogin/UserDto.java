package com.example.healthcare.healthcare.signuplogin;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;


    @Column(nullable = false)
    private String username;

    @Column(unique = true, nullable = false)  // Ensures email is unique
    private String email;

    @Column(nullable = false)
    private String password;
    private String role;
    @Column(nullable = false)
    private String number;
    private String expertise;
    private String degree;
    private String image;
    private String schedule;
    private String credential;
    private String deskid;
    private boolean verified;


}
