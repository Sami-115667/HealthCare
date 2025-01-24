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
@Table(name = "prescription")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "doctor_id")
    private String doctorId;

    @Column(name = "patient_id")
    private String patientId;

    @Column(name = "patient_name")
    private String patientName;

    @Column(name = "disease", nullable = false, length = 255)
    private String diseaseName;

    @Column(name = "notes", length = 500)
    private String notes;

    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @Column(name = "medicine", columnDefinition = "TEXT")
    @Convert(converter = JsonListConverter.class)
    private List<Map<String, Object>> medicines;
}
