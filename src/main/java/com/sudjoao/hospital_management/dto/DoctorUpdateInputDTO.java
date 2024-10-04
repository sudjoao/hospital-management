package com.sudjoao.hospital_management.dto;

import java.util.Optional;

public record DoctorUpdateInputDTO(Optional<String> name, Optional<String> phone) {
}
