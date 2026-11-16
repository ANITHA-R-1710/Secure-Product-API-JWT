package com.example.SecureProductApi.controller;

import com.example.SecureProductApi.dto.AuthResponse;
import com.example.SecureProductApi.dto.LoginRequest;
import com.example.SecureProductApi.dto.RegisterRequest;
import com.example.SecureProductApi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}