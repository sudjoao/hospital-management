package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.Address;
import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.domain.SpecialityEnum;
import lombok.Builder;

@Builder
public record DoctorFullInfoOutputDto(Long id, String name, String email, String CRM, SpecialityEnum speciality,
                                      String phone,
                                      Address address) {
    public static DoctorFullInfoOutputDto fromDomain(Doctor doctor) {
        return DoctorFullInfoOutputDto.builder()
                .name(doctor.getName())
                .CRM(doctor.getCRM())
                .email(doctor.getEmail())
                .id(doctor.getId())
                .address(doctor.getAddress())
                .speciality(doctor.getSpeciality())
                .build();
    }
}
