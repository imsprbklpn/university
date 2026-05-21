package com.saparbek.university.university.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekEnrollmentDto {
    private Long id;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    private String studentUsername;

    @NotNull(message = "Course ID is required")
    private Long courseId;

    private String courseTitle;
}