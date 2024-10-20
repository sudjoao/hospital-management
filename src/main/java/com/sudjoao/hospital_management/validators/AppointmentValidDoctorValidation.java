package com.sudjoao.hospital_management.validators;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentValidDoctorValidation implements AppointmentCreationValidations {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public void validate(AppointmentInput appointmentInput) {
        var doctor = doctorRepository.getReferenceById(appointmentInput.doctorId());
        if (!doctor.getActive())
            throw new RuntimeException("Cannot create appointment: Doctor is inactive");
    }
}
