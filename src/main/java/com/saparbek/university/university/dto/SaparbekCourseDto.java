package com.saparbek.university.university.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekCourseDto {
    private Long id;
    private String title;
    private String description;
    private Long teacherId;
    private String teacherUsername;
}