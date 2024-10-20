package com.sudjoao.hospital_management.dto.input;

import com.sudjoao.hospital_management.domain.Appointment;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentInput(
        @NotNull
        Long patientId,
        LocalDateTime appointmentTime,
        Long doctorId
) {
    public Appointment toDomain() {
        return Appointment.builder()
                .appointmentTime(appointmentTime)
                .build();
    }
}
