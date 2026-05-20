package com.saparbek.university.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaparbekAuthRequest {
    private String username;
    private String password;
    private String email;
}