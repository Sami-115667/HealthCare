package com.example.healthcare.healthcare.model;

import com.example.healthcare.healthcare.model.DoctorEntity;
import com.example.healthcare.healthcare.model.Schedule;

public class DoctorScheduleRequest {
    private DoctorEntity doctor;
    private Schedule schedule;

    // Getters and Setters
    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
