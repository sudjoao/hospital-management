package com.sudjoao.hospital_management.domain;

import lombok.Builder;

@Builder
public class Doctor {
    Long id;
    String name;
    String email;
    String phone;
    String CRM;
    String speciality;
    Address address;
}
