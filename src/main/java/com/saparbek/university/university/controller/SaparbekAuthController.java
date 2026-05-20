package com.saparbek.university.university.controller;

import com.saparbek.university.university.dto.SaparbekAuthRequest;
import com.saparbek.university.university.entity.SaparbekRole;
import com.saparbek.university.university.entity.SaparbekUser;
import com.saparbek.university.university.repository.SaparbekUserRepository;
import com.saparbek.university.university.security.SaparbekJwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class SaparbekAuthController {

    private final SaparbekUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final SaparbekJwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SaparbekAuthRequest request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        SaparbekUser user = SaparbekUser.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(SaparbekRole.ROLE_STUDENT)
                .build();
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody SaparbekAuthRequest request) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()));
        String token = jwtUtil.generateToken(auth.getName());
        return ResponseEntity.ok(token);
    }
}