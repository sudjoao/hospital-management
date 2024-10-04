package com.sudjoao.hospital_management.repository;

import com.sudjoao.hospital_management.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
