package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.Patient;

public record PatientListOutput(Long id, String name, String email) {
    public static PatientListOutput fromDomain(Patient patient) {
        return new PatientListOutput(patient.getId(), patient.getName(), patient.getEmail());
    }
}
