package com.sudjoao.hospital_management.config;

import com.sudjoao.hospital_management.services.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class RequestFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("Filter called");
        var token = getToken(request);
        token.ifPresent(s -> System.out.println(tokenService.validateToken(s)));
        filterChain.doFilter(request, response);
    }

    private Optional<String> getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");
        if (header != null) {
            System.out.println(header);
            return Optional.of(header.replace("Bearer ", ""));
        }
        return Optional.empty();
    }
}
