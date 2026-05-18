package com.saparbek.university.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekAssignmentDto {
    private Long id;
    private String title;
    private String description;
    private Long courseId;
    private String courseTitle;
}