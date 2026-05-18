package com.saparbek.university.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekEnrollmentDto {
    private Long id;
    private Long studentId;
    private String studentUsername;
    private Long courseId;
    private String courseTitle;
}