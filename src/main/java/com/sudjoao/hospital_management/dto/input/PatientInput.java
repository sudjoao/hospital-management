package com.sudjoao.hospital_management.dto.input;

import com.sudjoao.hospital_management.domain.Patient;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record PatientInput(
        @NotBlank
        String name,
        @NotBlank
        String CPF,
        @NotBlank
        String email,
        @Valid
        AddressInput address
) {
    public Patient toDomain() {
        return Patient.builder()
                .name(name)
                .CPF(CPF)
                .email(email)
                .address(address.toDomain())
                .active(true)
                .build();
    }
}
