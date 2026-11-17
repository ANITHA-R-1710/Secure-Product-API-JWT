package com.example.SecureProductApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntime(RuntimeException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", "FAILED");
        error.put("message", ex.getMessage());
        error.put("errorCode", 400);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", "FAILED");
        error.put("message", "Something went wrong: " + ex.getMessage());
        error.put("errorCode", 500);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(org.springframework.security.authentication.BadCredentialsException.class)
    public ResponseEntity<Map<String, Object>> handleBadCredentials(Exception ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", "FAILED");
        error.put("message", "Invalid username or password");
        error.put("errorCode", 401);
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
}