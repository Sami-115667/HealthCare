package com.example.healthcare.healthcare.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "doctor_name")
    private String doctorName;

    @Column(name = "doctor_expertise")
    private String doctorExpertise;

    @Column(name = "fees")
    private double fees;

    @Column(name = "appointment_date")
    private String appointmentDate;

    @Column(name = "status")
    private String status ; // Default status

    @Column(name = "remarks")
    private String remarks;
}
