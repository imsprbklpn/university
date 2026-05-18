package com.saparbek.university.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private SaparbekUser teacher;

    @OneToMany(mappedBy = "course")
    private List<SaparbekEnrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<SaparbekAssignment> assignments;
}