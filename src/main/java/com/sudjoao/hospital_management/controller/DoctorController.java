package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.domain.Doctor;
import com.sudjoao.hospital_management.dto.DoctorCreateInputDTO;
import com.sudjoao.hospital_management.dto.DoctorFullInfoOutputDto;
import com.sudjoao.hospital_management.dto.DoctorOutputDTO;
import com.sudjoao.hospital_management.dto.DoctorUpdateInputDTO;
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
    ResponseEntity<DoctorFullInfoOutputDto> create(@RequestBody @Valid DoctorCreateInputDTO doctorCreateInputDTO, UriComponentsBuilder uriComponentsBuilder) {
        Doctor doctor = doctorRepository.save(doctorCreateInputDTO.toDomain());
        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(doctor.getId()).toUri();
        return ResponseEntity.created(uri).body(DoctorFullInfoOutputDto.fromDomain(doctor));
    }

    @GetMapping
    ResponseEntity<Page<DoctorOutputDTO>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<Doctor> doctors = doctorRepository.findAll(pageable);
        Page<DoctorOutputDTO> output = doctors.map(DoctorOutputDTO::fromDomain);
        return ResponseEntity.ok(output);
    }

    @PatchMapping("/{id}")
    @Transactional
    ResponseEntity<DoctorFullInfoOutputDto> edit(@PathVariable int id, @RequestBody DoctorUpdateInputDTO doctorInputDTO) {
        Doctor doctor = doctorRepository.getReferenceById((long) id);
        doctor.updateFromDto(doctorInputDTO);
        return ResponseEntity.ok(DoctorFullInfoOutputDto.fromDomain(doctor));
    }

    @GetMapping("/{id}")
    ResponseEntity<DoctorFullInfoOutputDto> getById(@PathVariable long id) {
        Doctor doctor = doctorRepository.getReferenceById(id);
        return ResponseEntity.ok(DoctorFullInfoOutputDto.fromDomain(doctor));
    }
}
