package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.Doctor;
import lombok.Builder;

@Builder
public record DoctorOutput(String name, String email, String CRM, String speciality) {
    public static DoctorOutput fromDomain(Doctor doctor) {
        return DoctorOutput.builder()
                .name(doctor.getName())
                .email(doctor.getEmail())
                .CRM(doctor.getCRM())
                .speciality(doctor.getSpeciality().name())
                .build();
    }
}
