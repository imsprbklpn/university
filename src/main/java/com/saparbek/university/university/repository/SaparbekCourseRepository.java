package com.saparbek.university.university.repository;

import com.saparbek.university.university.entity.SaparbekCourse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaparbekCourseRepository extends JpaRepository<SaparbekCourse, Long> {
    Page<SaparbekCourse> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}