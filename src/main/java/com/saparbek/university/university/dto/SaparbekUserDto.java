package com.saparbek.university.university.dto;

import com.saparbek.university.university.entity.SaparbekRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekUserDto {
    private Long id;
    private String username;
    private String email;
    private SaparbekRole role;
}