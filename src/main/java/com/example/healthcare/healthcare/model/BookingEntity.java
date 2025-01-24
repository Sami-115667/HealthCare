package com.example.healthcare.healthcare.model;

import com.example.healthcare.healthcare.config.JsonListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;


    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "appointment_date")
    private LocalDate appointmentDate;

    @Column(name = "appointment_day")
    private String appointmentDay;


    @Column(name = "data", columnDefinition = "TEXT")
    @Convert(converter = JsonListConverter.class)
    private List<Map<String, Object>> data;

}
