package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.Address;
import com.sudjoao.hospital_management.domain.Patient;

public record PatientOutput(Long id, String name, String email, String CPF, Address address) {
    public static PatientOutput fromDomain(Patient patient) {
        return new PatientOutput(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getCPF(),
                patient.getAddress()
        );
    }
}
