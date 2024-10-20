package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.output.AppointmentOutput;
import com.sudjoao.hospital_management.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("appointments")
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @GetMapping
    ResponseEntity<Page<AppointmentOutput>> listAppointments(@PageableDefault(size = 10) Pageable pageable) {
        return ResponseEntity.ok(appointmentRepository.findAll(pageable).map(AppointmentOutput::fromDomain));
    }
}
