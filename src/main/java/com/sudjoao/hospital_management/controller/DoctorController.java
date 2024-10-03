package com.sudjoao.hospital_management.controller;

import com.sudjoao.hospital_management.dto.DoctorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    ResponseEntity<String> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        return new ResponseEntity<>(doctorDTO.toString(), HttpStatusCode.valueOf(201));
    }
}
