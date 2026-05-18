package com.saparbek.university.university.repository;

import com.saparbek.university.university.entity.SaparbekEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SaparbekEnrollmentRepository extends JpaRepository<SaparbekEnrollment, Long> {
    List<SaparbekEnrollment> findByStudentId(Long studentId);
    List<SaparbekEnrollment> findByCourseId(Long courseId);
    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);
}