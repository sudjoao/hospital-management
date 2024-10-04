package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.dto.DoctorInputDTO;
import com.sudjoao.hospital_management.dto.DoctorOutputDTO;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    ResponseEntity<Page<DoctorOutputDTO>> list(Pageable pageable) {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        System.out.println(doctors);
        Page<DoctorOutputDTO> output = doctors.map(DoctorOutputDTO::fromDomain);
        return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));
    }
}
