package com.sudjoao.hospital_management.validators;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;

@Component
public class AppointmentTimeValidation implements AppointmentCreationValidations {
    @Override
    public void validate(AppointmentInput appointmentInput) {
        var time = appointmentInput.appointmentTime();
        if (time.getDayOfWeek().equals(DayOfWeek.SUNDAY) || time.getHour() > 19 || time.getHour() < 7)
            throw new RuntimeException("Cannot create the appointment: Out of work hour.");
    }
}
