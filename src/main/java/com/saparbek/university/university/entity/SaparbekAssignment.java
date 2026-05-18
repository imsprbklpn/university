package com.saparbek.university.university.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private SaparbekCourse course;

    @OneToMany(mappedBy = "assignment")
    private List<SaparbekSubmission> submissions;
}