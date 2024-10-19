package com.sudjoao.hospital_management.dto.input;

import com.sudjoao.hospital_management.domain.User;

public record UserInput(String username, String password) {
    public User toDomain() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
