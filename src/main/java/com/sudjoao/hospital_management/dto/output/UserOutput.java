package com.sudjoao.hospital_management.dto.output;

import com.sudjoao.hospital_management.domain.User;

public record UserOutput(Long id, String username) {
    public static UserOutput fromDomain(User user) {
        return new UserOutput(user.getId(), user.getUsername());
    }
}
