package com.saparbek.university.university.service;

import com.saparbek.university.university.dto.SaparbekEnrollmentDto;
import com.saparbek.university.university.entity.*;
import com.saparbek.university.university.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaparbekEnrollmentService {

    private final SaparbekEnrollmentRepository enrollmentRepository;
    private final SaparbekUserRepository userRepository;
    private final SaparbekCourseRepository courseRepository;

    public List<SaparbekEnrollmentDto> getAllEnrollments() {
        return enrollmentRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public SaparbekEnrollmentDto enroll(Long studentId, Long courseId) {
        SaparbekUser student = userRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        SaparbekCourse course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        SaparbekEnrollment enrollment = SaparbekEnrollment.builder()
                .student(student)
                .course(course)
                .build();
        return toDto(enrollmentRepository.save(enrollment));
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }

    private SaparbekEnrollmentDto toDto(SaparbekEnrollment e) {
        return SaparbekEnrollmentDto.builder()
                .id(e.getId())
                .studentId(e.getStudent().getId())
                .studentUsername(e.getStudent().getUsername())
                .courseId(e.getCourse().getId())
                .courseTitle(e.getCourse().getTitle())
                .build();
    }
}