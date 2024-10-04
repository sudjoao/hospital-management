package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.DoctorDTO;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping
    ResponseEntity<String> createDoctor(@RequestBody @Valid DoctorDTO doctorDTO) {
        return new ResponseEntity<>(doctorRepository.save(doctorDTO.toDomain()).toString(), HttpStatusCode.valueOf(201));
    }
}
