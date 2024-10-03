package com.sudjoao.hospital_management.dto;

public record DoctorDTO(String name, String email, String phone, String CRM, String speciality, AddressDTO address) {
    public record AddressDTO(String street, String number, String complement, String neighborhood, String city, String state, String zipCode){}
}
