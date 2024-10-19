package com.sudjoao.hospital_management.dto.input;

import java.util.Optional;

public record DoctorUpdateInput(Optional<String> name, Optional<String> phone) {
}
