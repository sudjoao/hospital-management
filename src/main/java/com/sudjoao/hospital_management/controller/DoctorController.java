package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.dto.DoctorInputDTO;
import com.sudjoao.hospital_management.dto.DoctorOutputDTO;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping
    ResponseEntity<String> create(@RequestBody @Valid DoctorInputDTO doctorInputDTO) {
        return new ResponseEntity<>(doctorRepository.save(doctorInputDTO.toDomain()).toString(), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    ResponseEntity<List<DoctorOutputDTO>> list() {
        List<Doctor> doctors = doctorRepository.findAll();
        System.out.println(doctors);
        List<DoctorOutputDTO> output = doctors.stream().map(DoctorOutputDTO::fromDomain).toList();
        return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));
    }
}
