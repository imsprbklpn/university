package com.saparbek.university.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekSubmissionDto {
    private Long id;
    private Long studentId;
    private String studentUsername;
    private Long assignmentId;
    private String assignmentTitle;
    private String fileUrl;
    private String comment;
}