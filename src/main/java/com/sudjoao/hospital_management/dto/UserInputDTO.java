package com.sudjoao.hospital_management.dto;

import com.sudjoao.hospital_management.domain.User;

public record UserInputDTO(String username, String password) {
    public User toDomain() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
