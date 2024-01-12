package com.application.backend.user.service;

import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    String getUsername(String token);

    String generateToken();
}
