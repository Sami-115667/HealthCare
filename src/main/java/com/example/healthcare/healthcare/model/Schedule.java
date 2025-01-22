package com.example.healthcare.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for the schedule table

    private Long doctorId;

    private  String Sun;
    private  String Mon;
    private  String Tue;
    private  String Wed;
    private  String Thu;
    private  String Fri;
    private  String Sat;
}
