package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.dto.DoctorCreateInputDTO;
import com.sudjoao.hospital_management.dto.DoctorOutputDTO;
import com.sudjoao.hospital_management.dto.DoctorUpdateInputDTO;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping
    ResponseEntity<String> create(@RequestBody @Valid DoctorCreateInputDTO doctorCreateInputDTO) {
        return new ResponseEntity<>(doctorRepository.save(doctorCreateInputDTO.toDomain()).toString(), HttpStatusCode.valueOf(201));
    }

    @GetMapping
    ResponseEntity<Page<DoctorOutputDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        Page<DoctorOutputDTO> output = doctors.map(DoctorOutputDTO::fromDomain);
        return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/{id}")
    @Transactional
    ResponseEntity edit(@PathVariable int id, @RequestBody DoctorUpdateInputDTO doctorInputDTO) {
        Optional<Doctor> doctor = doctorRepository.findById((long) id);
        if (doctor.isEmpty())
            return new ResponseEntity(HttpStatusCode.valueOf(404));
        doctor.get().updateFromDto(doctorInputDTO);
        return new ResponseEntity(HttpStatusCode.valueOf(200));
    }
}
