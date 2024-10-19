package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.output.PatientInput;
import com.sudjoao.hospital_management.dto.output.PatientListOutput;
import com.sudjoao.hospital_management.dto.output.PatientOutput;
import com.sudjoao.hospital_management.repository.PatientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping
    ResponseEntity<List<PatientListOutput>> listPatients() {
        return ResponseEntity.ok()
                .body(patientRepository.findAll().stream().map(PatientListOutput::fromDomain).toList());
    }

    @GetMapping("/{id}")
    ResponseEntity<PatientOutput> getById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(PatientOutput.fromDomain(patientRepository.getReferenceById(id)));
    }

    @PostMapping
    ResponseEntity<PatientOutput> createPatient(@Valid @RequestBody PatientInput patientInput, UriComponentsBuilder uriComponentsBuilder) {
        var patient = patientRepository.save(patientInput.toDomain());
        var uri = uriComponentsBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
        return ResponseEntity.created(uri).body(PatientOutput.fromDomain(patient));
    }
}
