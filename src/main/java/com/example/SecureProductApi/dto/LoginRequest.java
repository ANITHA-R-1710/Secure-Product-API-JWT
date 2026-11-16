package com.example.SecureProductApi.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}