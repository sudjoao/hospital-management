package com.sudjoao.hospital_management.repository;

import com.sudjoao.hospital_management.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
