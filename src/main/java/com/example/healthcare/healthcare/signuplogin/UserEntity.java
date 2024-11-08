package com.example.healthcare.healthcare.signuplogin;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
