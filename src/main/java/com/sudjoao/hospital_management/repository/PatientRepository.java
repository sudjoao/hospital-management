package com.sudjoao.hospital_management.repository;

import com.sudjoao.hospital_management.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
