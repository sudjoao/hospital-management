package com.sudjoao.hospital_management.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalDateTime appointmentTime;


    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    Patient patient;
}
