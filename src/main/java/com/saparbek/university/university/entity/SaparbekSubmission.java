package com.saparbek.university.university.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "submissions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaparbekSubmission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private SaparbekUser student;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private SaparbekAssignment assignment;

    private String fileUrl;

    private String comment;
}