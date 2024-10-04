package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.Address;
import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.domain.SpecialityEnum;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DoctorDTO(
        @NotBlank
        String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @Size(min = 5, max = 5)
        String CRM,
        @NotBlank
        @Valid
        String speciality,
        @Valid
        @NotNull
        AddressDTO address
) {
    public Doctor toDomain() {
        return Doctor.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .CRM(CRM)
                .speciality(SpecialityEnum.getByName(speciality))
                .address(address.toDomain())
                .build();
    }

    public record AddressDTO(
            @NotBlank
            String street,
            String number,
            String complement,
            @NotBlank
            String neighborhood,
            @NotBlank
            String city,
            @NotBlank
            String state,
            @NotBlank
            String zipCode
    ) {
        public Address toDomain() {
            return Address.builder()
                    .city(city)
                    .complement(complement)
                    .neighborhood(neighborhood)
                    .number(number)
                    .state(state)
                    .street(street)
                    .zipCode(zipCode)
                    .build();
        }
    }
}
