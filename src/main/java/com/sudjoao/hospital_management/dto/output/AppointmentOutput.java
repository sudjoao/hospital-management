package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.Appointment;

import java.time.LocalDateTime;

public record AppointmentOutput(Long id, Long patientId, Long doctorId, LocalDateTime appointmentTime) {
    public static AppointmentOutput fromDomain(Appointment appointment) {
        return new AppointmentOutput(appointment.getId(), appointment.getPatient().getId(), appointment.getDoctor().getId(), appointment.getAppointmentTime());
    }
}
