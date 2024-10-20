package com.sudjoao.hospital_management.validators;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AppointmentAdvanceValidation implements AppointmentCreationValidations {
    @Override
    public void validate(AppointmentInput appointmentInput) {
        System.out.println(appointmentInput.appointmentTime());
        System.out.println(LocalDateTime.now());
        System.out.println(Duration.between(appointmentInput.appointmentTime(), LocalDateTime.now()).toMinutes());
        if (Duration.between(LocalDateTime.now(), appointmentInput.appointmentTime()).toMinutes() < 30)
            throw new RuntimeException("Cannot create a appointment: minimum 30min of advance.");
    }
}
