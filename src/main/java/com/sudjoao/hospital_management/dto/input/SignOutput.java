package com.sudjoao.hospital_management.dto.input;

public record SignOutput(String token) {
    public static SignOutput of(String token) {
        return new SignOutput(token);
    }
}
