package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.input.PatientInput;
import com.sudjoao.hospital_management.dto.output.PatientListOutput;
import com.sudjoao.hospital_management.dto.output.PatientOutput;
import com.sudjoao.hospital_management.repository.PatientRepository;
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
@RequestMapping("patients")
public class PatientController {

    @Autowired
    PatientRepository patientRepository;

    @GetMapping
    ResponseEntity<Page<PatientListOutput>> listPatients(@PageableDefault(size = 10, sort = {"name"}) Pageable pageable) {
        Page<PatientListOutput> page = patientRepository.findAll(pageable).map(PatientListOutput::fromDomain);
        return ResponseEntity.ok()
                .body(page);
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

    @DeleteMapping("/{id}")
    @Transactional
    ResponseEntity deletePatient(@PathVariable long id) {
        var patient = patientRepository.getReferenceById(id);
        patient.delete();
        return ResponseEntity.noContent().build();
    }
}
