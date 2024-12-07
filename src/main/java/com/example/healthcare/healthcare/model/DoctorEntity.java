package com.example.healthcare.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "doctor")
public class DoctorEntity {

    @Id
    private Long id; // Primary key for the doctor table


    private String description; // Additional description about the doctor


    private double fees; // Consultation fees for the doctor


    private  String schedule;
}
