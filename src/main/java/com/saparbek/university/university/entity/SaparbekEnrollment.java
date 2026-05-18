package com.saparbek.university.university.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "enrollments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private SaparbekUser student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private SaparbekCourse course;
}