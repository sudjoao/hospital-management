package com.sudjoao.hospital_management.domain;

import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "doctors")
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phone;
    String CRM;
    SpecialityEnum speciality;
    @Embedded
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
