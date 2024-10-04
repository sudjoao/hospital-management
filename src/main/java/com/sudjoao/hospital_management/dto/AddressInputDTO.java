package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.Address;
import jakarta.validation.constraints.NotBlank;

public record AddressInputDTO(
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
