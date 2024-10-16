package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.User;

public record UserOutputDTO(Long id, String username) {
    public static UserOutputDTO fromDomain(User user) {
        return new UserOutputDTO(user.getId(), user.getUsername());
    }
}
