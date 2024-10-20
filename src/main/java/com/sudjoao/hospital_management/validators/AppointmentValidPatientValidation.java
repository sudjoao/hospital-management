package com.sudjoao.hospital_management.validators;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import com.sudjoao.hospital_management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentValidPatientValidation implements AppointmentCreationValidations {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void validate(AppointmentInput appointmentInput) {
        var patient = patientRepository.getReferenceById(appointmentInput.patientId());
        if (!patient.getActive())
            throw new RuntimeException("Cannot create appointment: patient inactive");
    }
}
