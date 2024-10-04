package com.sudjoao.hospital_management.domain;

import com.sudjoao.hospital_management.dto.DoctorUpdateInputDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "doctors")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String email;
    String phone;
    String CRM;
    @Enumerated(EnumType.STRING)
    SpecialityEnum speciality;
    @Embedded
    Address address;

    public void updateFromDto(DoctorUpdateInputDTO doctorUpdateInputDTO) {
        phone = doctorUpdateInputDTO.phone().orElse(phone);
        name = doctorUpdateInputDTO.name().orElse(name);
    }

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
