package com.sudjoao.hospital_management.dto;

public record SignOutputDTO(String token) {
    public static SignOutputDTO of(String token) {
        return new SignOutputDTO(token);
    }
}
