package com.saparbek.university.university.repository;

import com.saparbek.university.university.entity.SaparbekAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaparbekAssignmentRepository extends JpaRepository<SaparbekAssignment, Long> {
    List<SaparbekAssignment> findByCourseId(Long courseId);
}