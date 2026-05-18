package com.saparbek.university.university.repository;

import com.saparbek.university.university.entity.SaparbekSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaparbekSubmissionRepository extends JpaRepository<SaparbekSubmission, Long> {
    List<SaparbekSubmission> findByStudentId(Long studentId);
    List<SaparbekSubmission> findByAssignmentId(Long assignmentId);
}