package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.Doctor;
import lombok.Builder;

@Builder
public record DoctorOutputDTO(String name, String email, String CRM, String speciality) {
    public static DoctorOutputDTO fromDomain(Doctor doctor) {
        return DoctorOutputDTO.builder()
                .name(doctor.getName())
                .email(doctor.getEmail())
                .CRM(doctor.getCRM())
                .speciality(doctor.getSpeciality().name())
                .build();
    }
}
