package com.sudjoao.hospital_management.validators;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;

public interface AppointmentCreationValidations {
    void validate(AppointmentInput appointmentInput);
}
