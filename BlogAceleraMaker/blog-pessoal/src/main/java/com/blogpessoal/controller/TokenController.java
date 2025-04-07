package com.blogpessoal.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogpessoal.security.JwtService;

@RestController
@RequestMapping("/api")
public class TokenController {

    @Autowired
    private JwtService jwtService;

    
    @GetMapping("/validar-token")
    public ResponseEntity<?> validar(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // remove "Bearer "
            
            if (jwtService.validateToken(token)) {
                return ResponseEntity.ok(Collections.singletonMap("status", "válido"));
            }
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Token inválido");
    }


}
