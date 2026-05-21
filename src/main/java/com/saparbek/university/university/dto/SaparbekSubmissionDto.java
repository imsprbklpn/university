package com.saparbek.university.university.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekSubmissionDto {
    private Long id;

    @NotNull(message = "Student ID is required")
    private Long studentId;

    private String studentUsername;

    @NotNull(message = "Assignment ID is required")
    private Long assignmentId;

    private String assignmentTitle;
    private String fileUrl;
    private String comment;
}