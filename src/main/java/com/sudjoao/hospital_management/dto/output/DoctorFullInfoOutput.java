package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.Address;
import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.domain.SpecialityEnum;
import lombok.Builder;

@Builder
public record DoctorFullInfoOutput(Long id, String name, String email, String CRM, SpecialityEnum speciality,
                                   String phone,
                                   Address address) {
    public static DoctorFullInfoOutput fromDomain(Doctor doctor) {
        return DoctorFullInfoOutput.builder()
                .name(doctor.getName())
                .CRM(doctor.getCRM())
                .email(doctor.getEmail())
                .id(doctor.getId())
                .address(doctor.getAddress())
                .speciality(doctor.getSpeciality())
                .build();
    }
}
