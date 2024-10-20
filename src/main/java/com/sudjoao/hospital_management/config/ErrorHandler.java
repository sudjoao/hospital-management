package com.sudjoao.hospital_management.config;

import com.sudjoao.hospital_management.dto.output.ErrorOutput;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity handleNotFoundError() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<ErrorOutput> handleInvalidArgumentsError(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors().stream().map(e -> "%s - %s".formatted(e.getField(), e.getDefaultMessage()));
        return ResponseEntity.badRequest().body(new ErrorOutput(errors));
    }

    @ExceptionHandler(RuntimeException.class)
    ResponseEntity<ErrorOutput> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(new ErrorOutput(exception.getMessage()));
    }
}
