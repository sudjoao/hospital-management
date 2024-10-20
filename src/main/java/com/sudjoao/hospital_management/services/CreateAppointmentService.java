package com.sudjoao.hospital_management.services;

import com.sudjoao.hospital_management.domain.Appointment;
import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import com.sudjoao.hospital_management.repository.AppointmentRepository;
import com.sudjoao.hospital_management.validators.AppointmentCreationValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateAppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    List<AppointmentCreationValidations> validations;

    public Appointment createAppointment(AppointmentInput appointmentInput) {
        validations.forEach(v -> v.validate(appointmentInput));
        return new Appointment();
    }
}
