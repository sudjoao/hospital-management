package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.input.AppointmentInput;
import com.sudjoao.hospital_management.dto.output.AppointmentOutput;
import com.sudjoao.hospital_management.repository.AppointmentRepository;
import com.sudjoao.hospital_management.services.CreateAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    CreateAppointmentService createAppointmentService;

    @PostMapping
    ResponseEntity<AppointmentOutput> createAppointment(@RequestBody @Valid AppointmentInput appointmentInput) {
        var appointment = createAppointmentService.createAppointment(appointmentInput);
        return ResponseEntity.ok(AppointmentOutput.fromDomain(appointment));
    }

    @GetMapping
    ResponseEntity<Page<AppointmentOutput>> listAppointments(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(appointmentRepository.findAll(pageable).map(AppointmentOutput::fromDomain));
    }
}
