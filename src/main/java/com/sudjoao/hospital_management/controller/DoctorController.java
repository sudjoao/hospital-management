package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.dto.input.DoctorCreateInput;
import com.sudjoao.hospital_management.dto.input.DoctorUpdateInput;
import com.sudjoao.hospital_management.dto.output.DoctorFullInfoOutput;
import com.sudjoao.hospital_management.dto.output.DoctorOutput;
import com.sudjoao.hospital_management.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping
    ResponseEntity<DoctorFullInfoOutput> create(@RequestBody @Valid DoctorCreateInput doctorCreateInput, UriComponentsBuilder uriComponentsBuilder) {
        Doctor doctor = doctorRepository.save(doctorCreateInput.toDomain());
        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(DoctorFullInfoOutput.fromDomain(doctor));
    }

    @GetMapping
    ResponseEntity<Page<DoctorOutput>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        Page<DoctorOutput> output = doctors.map(DoctorOutput::fromDomain);
        return ResponseEntity.ok(output);
    }

    @PatchMapping("/{id}")
    @Transactional
    ResponseEntity<DoctorFullInfoOutput> edit(@PathVariable int id, @RequestBody DoctorUpdateInput doctorInputDTO) {
        Doctor doctor = doctorRepository.getReferenceById((long) id);
        doctor.updateFromDto(doctorInputDTO);
        return ResponseEntity.ok(DoctorFullInfoOutput.fromDomain(doctor));
    }

    @GetMapping("/{id}")
    ResponseEntity<DoctorFullInfoOutput> getById(@PathVariable long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(DoctorFullInfoOutput.fromDomain(doctor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity deleteDoctor(@PathVariable long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        doctor.delete();
        return ResponseEntity.noContent().build();
    }
}
