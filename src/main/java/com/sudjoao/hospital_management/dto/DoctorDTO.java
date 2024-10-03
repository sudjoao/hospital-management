package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.Address;
import com.sudjoao.hospital_management.domain.Doctor;

public record DoctorDTO(String name, String email, String phone, String CRM, String speciality, AddressDTO address) {
    public Doctor toDomain() {
        return Doctor.builder()
                .name(name)
                .email(email)
                .phone(phone)
                .CRM(CRM)
                .speciality(speciality)
                .address(address.toDomain())
                .build();
    }

    public record AddressDTO(String street, String number, String complement, String neighborhood, String city,
                             String state, String zipCode) {
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
