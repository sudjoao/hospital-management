package com.sudjoao.hospital_management.domain;

import lombok.Builder;

@Builder
public class Doctor {
    Long id;
    String name;
    String email;
    String phone;
    String CRM;
    SpecialityEnum speciality;
    Address address;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", CRM='" + CRM + '\'' +
                ", speciality=" + speciality +
                ", address=" + address +
                '}';
    }
}
