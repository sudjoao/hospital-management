package com.sudjoao.hospital_management.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sudjoao.hospital_management.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("jwt.secret")
    String secret;

    public String generateToken(User user) {
        var algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withIssuer("hospital-management-api")
                .withSubject(user.getUsername())
                .withExpiresAt(getExpiresAt())
                .sign(algorithm);
    }

    private Instant getExpiresAt() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
