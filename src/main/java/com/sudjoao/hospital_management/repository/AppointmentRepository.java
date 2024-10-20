package com.sudjoao.hospital_management.repository;

import com.sudjoao.hospital_management.domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
